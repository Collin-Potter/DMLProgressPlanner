package com.capotter.dmlprogressplanner.ui.IssuesActivity

import android.app.Application
import android.service.autofill.UserData
import androidx.lifecycle.*
import com.capotter.dmlprogressplanner.base.BaseViewModel
import com.capotter.dmlprogressplanner.data.model.GitHubRepository
import com.capotter.dmlprogressplanner.data.model.Issue
import com.capotter.dmlprogressplanner.data.model.User
import com.capotter.dmlprogressplanner.data.persistence.GitHubRepository.GitHubRepositoryDatabase
import com.capotter.dmlprogressplanner.data.persistence.Issue.IssueDatabase
import com.capotter.dmlprogressplanner.data.persistence.User.UserDatabase
import com.capotter.dmlprogressplanner.data.repository.GitHubRepositoryRepository
import com.capotter.dmlprogressplanner.data.repository.IssueRepository
import com.capotter.dmlprogressplanner.data.repository.UserRepository
import com.capotter.dmlprogressplanner.data.repository.utils.AppDispatchers
import com.capotter.dmlprogressplanner.data.repository.utils.Resource
import com.capotter.dmlprogressplanner.ui.domain.GetIssueListUseCase
import kotlinx.coroutines.*

class IssuesActivityViewModel(private val getIssueListUseCase: GetIssueListUseCase,
                              private val dispatchers: AppDispatchers) : BaseViewModel() {

    //PRIVATE DATA
    private lateinit var argsLogin: String
    private var userSource: LiveData<Resource<User>> = MutableLiveData()
    private var repoSource: LiveData<Resource<List<GitHubRepository>>> = MutableLiveData()
    private var issueSource: LiveData<Resource<List<Issue>>> = MutableLiveData()

    private val _user = MediatorLiveData<User>()
    val user: LiveData<User> get() = _user
    private val _repoList = MediatorLiveData<List<GitHubRepository>>()
    val repoList: LiveData<List<GitHubRepository>> get() = _repoList
    private val _issueList = MediatorLiveData<List<Issue>>()
    val issueList: LiveData<List<Issue>> get() = _issueList
    private val _isLoading = MutableLiveData<Resource.Status>()
    val isLoading: LiveData<Resource.Status> get() = _isLoading

    //PUBLIC ACTIONS
    fun loadDataWhenActivityStarts(login: String) {
        argsLogin = login
        getIssueList(false)
    }

    fun reloadDataWhenUserRefreshes()
        = getIssueList(true)

    // ---

    private fun getIssueList(forceRefresh: Boolean) = viewModelScope.launch {
        _issueList.removeSource(issueSource)
        //TODO: Figure out how to iteratively grab issue list for each repository
        for(i in repoList.value!!){
            withContext(dispatchers.io) { issueSource = getIssueListUseCase(forceRefresh = forceRefresh, login = argsLogin, repo = i.name!!)}
        }
    }
}