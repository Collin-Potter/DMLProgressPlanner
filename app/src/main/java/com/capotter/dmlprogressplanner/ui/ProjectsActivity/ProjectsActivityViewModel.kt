package com.capotter.dmlprogressplanner.ui.ProjectsActivity

import android.app.Application
import androidx.lifecycle.*
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProjectsActivityViewModel(application: Application) : AndroidViewModel(application) {

    private var userRepository: UserRepository
    val userList: LiveData<List<User>>

    private val gitHubRepositoryRepository: GitHubRepositoryRepository
    val repoList: LiveData<List<GitHubRepository>>

    private val projectsRepository: ProjectRepository
    val projectList: LiveData<List<Project>>

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        userRepository = UserRepository(userDao)
        userList = userRepository.getUsers()

        val gitHubRepoDao = GitHubRepositoryDatabase.getDatabase(application).repoDao()
        gitHubRepositoryRepository = GitHubRepositoryRepository(gitHubRepoDao)
        repoList = gitHubRepositoryRepository.getRepositoryList()

        val projectDao = ProjectDatabase.getDatabase(application).projectDao()
        projectsRepository = ProjectRepository(projectDao)
        projectList = projectsRepository.getProjects()
    }

    /**
     * Heavy operation that cannot be done in the Main Thread
     */
    fun launchDataLoad() {
        viewModelScope.launch {
            retrieveUsers()
            retrieveRepositories()
            retrieveProjects()
            // TODO: Modify UI
        }
    }

    suspend fun retrieveUsers() = withContext(Dispatchers.Default) {
        // Coroutine for potential large quantities of users
    }

    suspend fun retrieveRepositories() = withContext(Dispatchers.Default) {
        // Coroutine for potential large quantities of repositories

    }

    suspend fun retrieveProjects() = withContext(Dispatchers.Default) {
        // Coroutine for potential large quantities of projects

    }
}