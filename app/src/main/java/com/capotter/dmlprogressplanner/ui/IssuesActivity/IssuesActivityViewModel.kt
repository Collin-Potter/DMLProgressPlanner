package com.capotter.dmlprogressplanner.ui.IssuesActivity

import android.app.Application
import android.service.autofill.UserData
import androidx.lifecycle.*
import com.capotter.dmlprogressplanner.data.model.GitHubRepository
import com.capotter.dmlprogressplanner.data.model.Issue
import com.capotter.dmlprogressplanner.data.model.User
import com.capotter.dmlprogressplanner.data.persistence.GitHubRepository.GitHubRepositoryDatabase
import com.capotter.dmlprogressplanner.data.persistence.Issue.IssueDatabase
import com.capotter.dmlprogressplanner.data.persistence.User.UserDatabase
import com.capotter.dmlprogressplanner.data.repository.GitHubRepositoryRepository
import com.capotter.dmlprogressplanner.data.repository.IssueRepository
import com.capotter.dmlprogressplanner.data.repository.UserRepository
import kotlinx.coroutines.*

class IssuesActivityViewModel(application: Application) : AndroidViewModel(application) {

    private var userRepository: UserRepository
    val userList: LiveData<List<User>>

    private val gitHubRepositoryRepository: GitHubRepositoryRepository
    val repoList: LiveData<List<GitHubRepository>>

    private val issuesRepository: IssueRepository
    val issueList: LiveData<List<Issue>>

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        userRepository = UserRepository(userDao)
        userList = userRepository.getUsers()

        val gitHubRepoDao = GitHubRepositoryDatabase.getDatabase(application).repoDao()
        gitHubRepositoryRepository = GitHubRepositoryRepository(gitHubRepoDao)
        repoList = gitHubRepositoryRepository.getRepositoryList()

        val issueDao = IssueDatabase.getDatabase(application).issueDao()
        issuesRepository = IssueRepository(issueDao)
        issueList = issuesRepository.getIssuesList()
    }

    /**
     * Heavy operation that cannot be done in the Main Thread
     */
    fun launchDataLoad() {
        viewModelScope.launch {
            retrieveUsers()
            retrieveRepositories()
            retrieveIssues()
            // TODO: Modify UI
        }
    }

    suspend fun retrieveUsers() = withContext(Dispatchers.Default) {
        // Coroutine for potential large quantities of users
    }

    suspend fun retrieveRepositories() = withContext(Dispatchers.Default) {
        // Coroutine for potential large quantities of repositories

    }

    suspend fun retrieveIssues() = withContext(Dispatchers.Default) {
        // Coroutine for potential large quantities of issues

    }

}