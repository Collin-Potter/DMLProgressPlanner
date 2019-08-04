package com.capotter.dmlprogressplanner.ui.MilestonesActivity

import android.app.Application
import androidx.lifecycle.*
import com.capotter.dmlprogressplanner.data.model.GitHubRepository
import com.capotter.dmlprogressplanner.data.model.Milestone
import com.capotter.dmlprogressplanner.data.model.User
import com.capotter.dmlprogressplanner.data.persistence.GitHubRepository.GitHubRepositoryDatabase
import com.capotter.dmlprogressplanner.data.persistence.Milestone.MilestoneDatabase
import com.capotter.dmlprogressplanner.data.persistence.User.UserDatabase
import com.capotter.dmlprogressplanner.data.repository.GitHubRepositoryRepository
import com.capotter.dmlprogressplanner.data.repository.MilestoneRepository
import com.capotter.dmlprogressplanner.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MilestonesActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository: UserRepository
    val userList: LiveData<List<User>>

    private val gitHubRepositoryRepository: GitHubRepositoryRepository
    val repoList: LiveData<List<GitHubRepository>>

    private val milestonesRepository: MilestoneRepository
    val milestoneList: LiveData<List<Milestone>>

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        userRepository = UserRepository(userDao)
        userList = userRepository.getUsers()

        val gitHubRepoDao = GitHubRepositoryDatabase.getDatabase(application).repoDao()
        gitHubRepositoryRepository = GitHubRepositoryRepository(gitHubRepoDao)
        repoList = gitHubRepositoryRepository.getRepositoryList()

        val milestoneDao = MilestoneDatabase.getDatabase(application).milestoneDao()
        milestonesRepository = MilestoneRepository(milestoneDao)
        milestoneList = milestonesRepository.getMilestones()
    }

    /**
     * Heavy operation that cannot be done in the Main Thread
     */
    fun launchDataLoad() {
        viewModelScope.launch {
            retrieveUsers()
            retrieveRepositories()
            retrieveMilestones()
            // TODO: Modify UI
        }
    }

    suspend fun retrieveUsers() = withContext(Dispatchers.Default) {
        // Coroutine for potential large quantities of users
    }

    suspend fun retrieveRepositories() = withContext(Dispatchers.Default) {
        // Coroutine for potential large quantities of repositories

    }

    suspend fun retrieveMilestones() = withContext(Dispatchers.Default) {
        // Coroutine for potential large quantities of milestones

    }
}