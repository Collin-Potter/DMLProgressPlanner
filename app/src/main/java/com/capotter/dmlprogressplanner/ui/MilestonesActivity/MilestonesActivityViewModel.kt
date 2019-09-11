package com.capotter.dmlprogressplanner.ui.MilestonesActivity

import android.app.Application
import androidx.lifecycle.*
import com.capotter.dmlprogressplanner.base.BaseViewModel
import com.capotter.dmlprogressplanner.data.model.GitHubRepository
import com.capotter.dmlprogressplanner.data.model.Milestone
import com.capotter.dmlprogressplanner.data.model.User
import com.capotter.dmlprogressplanner.data.persistence.GitHubRepository.GitHubRepositoryDatabase
import com.capotter.dmlprogressplanner.data.persistence.Milestone.MilestoneDatabase
import com.capotter.dmlprogressplanner.data.persistence.User.UserDatabase
import com.capotter.dmlprogressplanner.data.repository.GitHubRepositoryRepository
import com.capotter.dmlprogressplanner.data.repository.MilestoneRepository
import com.capotter.dmlprogressplanner.data.repository.UserRepository
import com.capotter.dmlprogressplanner.data.repository.utils.AppDispatchers
import com.capotter.dmlprogressplanner.data.repository.utils.Resource
import com.capotter.dmlprogressplanner.ui.domain.GetMilestoneListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MilestonesActivityViewModel(private val getMilestonesUseCase: GetMilestoneListUseCase,
                                  private val dispatchers: AppDispatchers) : BaseViewModel() {

    //PRIVATE DATA
    private lateinit var argsLogin: String
    private var userSource: LiveData<Resource<User>> = MutableLiveData()
    private var repoSource: LiveData<Resource<List<GitHubRepository>>> = MutableLiveData()
    private var milestoneSource: LiveData<Resource<List<Milestone>>> = MutableLiveData()

    private val _user = MediatorLiveData<User>()
    val user: LiveData<User> get() = _user
    private val _repoList = MediatorLiveData<List<GitHubRepository>>()
    val repoList: LiveData<List<GitHubRepository>> get() = _repoList
    private val _milestoneList = MediatorLiveData<List<Milestone>>()
    val milestoneList: LiveData<List<Milestone>> get() = _milestoneList
    private val _isLoading = MutableLiveData<Resource.Status>()
    val isLoading: LiveData<Resource.Status> get() = _isLoading

    //PUBLIC ACTIONS
    fun loadDataWhenActivityStarts(login: String) {
        argsLogin = login
        getMilestoneList(false)
    }

    // ---

    private fun getMilestoneList(forceRefresh: Boolean) = viewModelScope.launch {
        _milestoneList.removeSource(milestoneSource)

        for(i in repoList.value!!) {
            withContext(dispatchers.io) { milestoneSource = getMilestonesUseCase(forceRefresh = forceRefresh, login = argsLogin, repo = i.name!!)}
        }
    }
}