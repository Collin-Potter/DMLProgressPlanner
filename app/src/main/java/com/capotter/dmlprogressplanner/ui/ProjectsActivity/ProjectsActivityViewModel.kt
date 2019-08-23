package com.capotter.dmlprogressplanner.ui.ProjectsActivity

import android.app.Application
import androidx.lifecycle.*
import com.capotter.dmlprogressplanner.R
import com.capotter.dmlprogressplanner.base.BaseViewModel
import com.capotter.dmlprogressplanner.data.model.GitHubRepository
import com.capotter.dmlprogressplanner.data.model.Project
import com.capotter.dmlprogressplanner.data.model.User
import com.capotter.dmlprogressplanner.data.persistence.GitHubRepository.GitHubRepositoryDatabase
import com.capotter.dmlprogressplanner.data.persistence.Project.ProjectDatabase
import com.capotter.dmlprogressplanner.data.persistence.Project.ProjectDatabase_Impl
import com.capotter.dmlprogressplanner.data.persistence.User.UserDatabase
import com.capotter.dmlprogressplanner.data.repository.GitHubRepositoryRepository
import com.capotter.dmlprogressplanner.data.repository.ProjectRepository
import com.capotter.dmlprogressplanner.data.repository.UserRepository
import com.capotter.dmlprogressplanner.data.repository.utils.AppDispatchers
import com.capotter.dmlprogressplanner.data.repository.utils.Resource
import com.capotter.dmlprogressplanner.ui.domain.GetRepoListUseCase
import com.capotter.dmlprogressplanner.util.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProjectsActivityViewModel(private val getUserDetailUseCase: GetRepoListUseCase,
                                private val dispatchers: AppDispatchers) : BaseViewModel() {

    //PRIVATE DATA
    private lateinit var argsLogin: String
    private var userSource: LiveData<Resource<User>> = MutableLiveData()
    private var repoSource: LiveData<Resource<List<GitHubRepository>>> = MutableLiveData()

    private val _user = MediatorLiveData<User>()
    val user: LiveData<User> get() = _user
    private val _repoList = MediatorLiveData<List<GitHubRepository>>()
    val repoList: LiveData<List<GitHubRepository>> get() = _repoList
    private val _isLoading = MutableLiveData<Resource.Status>()
    val isLoading: LiveData<Resource.Status> get() = _isLoading

    //PUBLIC ACTIONS
    fun loadDataWhenActivityStarts(login: String) {
        argsLogin = login
        getRepoList(false)
    }

    fun reloadDataWhenUserRefreshes()
        = getRepoList(true)

    // ---

    private fun getRepoList(forceRefresh: Boolean) = viewModelScope.launch(dispatchers.main){
        _repoList.removeSource(repoSource)
        withContext(dispatchers.io) { repoSource = getUserDetailUseCase(forceRefresh = forceRefresh, login = argsLogin)}
        _repoList.addSource(repoSource) {
            _repoList.value = it.data
            _isLoading.value = it.status
            if (it.status == Resource.Status.ERROR) _snackbarError.value = Event(R.string.snackbar_error_msg)
        }
    }
}