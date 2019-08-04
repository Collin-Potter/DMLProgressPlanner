package com.capotter.dmlprogressplanner.data.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.capotter.dmlprogressplanner.data.model.GitHubRepository
import com.capotter.dmlprogressplanner.data.persistence.GitHubRepository.GitHubRepositoryDao

class GitHubRepositoryRepository(private val gitHubRepositoryDao: GitHubRepositoryDao) {

    private var repoList: LiveData<List<GitHubRepository>> = gitHubRepositoryDao.getRepos()

    fun getRepositoryList(): LiveData<List<GitHubRepository>> {
        return repoList
    }

    @WorkerThread
    suspend fun insertRepo(repo: GitHubRepository) {
        gitHubRepositoryDao.insertRepo(repo)
    }
}