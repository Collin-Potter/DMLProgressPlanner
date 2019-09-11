package com.capotter.dmlprogressplanner.data.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.capotter.dmlprogressplanner.data.model.ApiResult
import com.capotter.dmlprogressplanner.data.model.GitHubRepository
import com.capotter.dmlprogressplanner.data.model.Issue
import com.capotter.dmlprogressplanner.data.persistence.Issue.IssueDao
import com.capotter.dmlprogressplanner.data.remote.Issue.IssueClient
import com.capotter.dmlprogressplanner.data.repository.utils.NetworkBoundResource
import com.capotter.dmlprogressplanner.data.repository.utils.Resource
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.SupervisorJob

interface IssueRepository {
    suspend fun getIssuesWithCache(forceRefresh: Boolean = false, user: String, repo: String): LiveData<Resource<List<Issue>>>
}

class IssueRepositoryImpl(private val datasource: IssueClient,
                          private val dao: IssueDao): IssueRepository {
    override suspend fun getIssuesWithCache(
        forceRefresh: Boolean,
        user: String,
        repo: String
    ): LiveData<Resource<List<Issue>>> {
        return object : NetworkBoundResource<List<Issue>, ApiResult<Issue>>() {
            override fun processResponse(response: ApiResult<Issue>): List<Issue>
                = response.items

            override suspend fun saveCallResults(items: List<Issue>)
                = dao.insertIssues(items)

            override fun shouldFetch(data: List<Issue>?): Boolean
                = data == null || data.isEmpty() || forceRefresh

            override suspend fun loadFromDb(): List<Issue>
                = dao.getIssues()

            override fun createCallAsync(): Deferred<ApiResult<Issue>>
                = datasource.fetchIssuesForRepo(user,repo)
        }.build().asLiveData()
    }
}