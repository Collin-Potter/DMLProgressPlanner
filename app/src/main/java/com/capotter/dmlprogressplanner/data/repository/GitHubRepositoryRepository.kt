package com.capotter.dmlprogressplanner.data.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.capotter.dmlprogressplanner.data.model.ApiResult
import com.capotter.dmlprogressplanner.data.model.GitHubRepository
import com.capotter.dmlprogressplanner.data.persistence.GitHubRepository.GitHubRepositoryDao
import com.capotter.dmlprogressplanner.data.remote.GitHubRepo.GitHubRepoClient
import com.capotter.dmlprogressplanner.data.repository.utils.NetworkBoundResource
import com.capotter.dmlprogressplanner.data.repository.utils.Resource
import kotlinx.coroutines.Deferred

interface GitHubRepositoryRepository {
    suspend fun getRepositoriesWithCache(forceRefresh: Boolean = false, login: String): LiveData<Resource<List<GitHubRepository>>>
}

class GitHubRepositoryRepositoryImpl(private val datasource: GitHubRepoClient,
                                     private val dao: GitHubRepositoryDao): GitHubRepositoryRepository {
    override suspend fun getRepositoriesWithCache(forceRefresh: Boolean, login: String): LiveData<Resource<List<GitHubRepository>>> {
        return object : NetworkBoundResource<List<GitHubRepository>, ApiResult<GitHubRepository>>() {
            override fun processResponse(response: ApiResult<GitHubRepository>): List<GitHubRepository>
                = response.items

            override suspend fun saveCallResults(items: List<GitHubRepository>)
                = dao.insertRepos(items)

            override fun shouldFetch(data: List<GitHubRepository>?): Boolean
                = data == null || data.isEmpty() || forceRefresh

            override suspend fun loadFromDb(): List<GitHubRepository>
                = dao.getRepos()

            override fun createCallAsync(): Deferred<ApiResult<GitHubRepository>>
                = datasource.fetchRepositories(login)

        }.build().asLiveData()
    }
}