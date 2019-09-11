package com.capotter.dmlprogressplanner.data.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.capotter.dmlprogressplanner.data.model.ApiResult
import com.capotter.dmlprogressplanner.data.model.Milestone
import com.capotter.dmlprogressplanner.data.persistence.Milestone.MilestoneDao
import com.capotter.dmlprogressplanner.data.remote.Milestone.MilestoneClient
import com.capotter.dmlprogressplanner.data.repository.utils.NetworkBoundResource
import com.capotter.dmlprogressplanner.data.repository.utils.Resource
import kotlinx.coroutines.Deferred

interface MilestoneRepository {
    suspend fun getMilestonesWithCache(forceRefresh: Boolean = false, user: String, repo: String): LiveData<Resource<List<Milestone>>>
}

class MilestoneRepositoryImpl(private val datasource: MilestoneClient,
                              private val dao: MilestoneDao): MilestoneRepository {
    override suspend fun getMilestonesWithCache(
        forceRefresh: Boolean,
        user: String,
        repo: String
    ): LiveData<Resource<List<Milestone>>> {
        //TODO: Figure out what isn't working here
        return object : NetworkBoundResource<List<Milestone>, ApiResult<Milestone>>() {
            override fun processResponse(response: ApiResult<Milestone>): List<Milestone>
                = response.items

            //TODO: Create insertMilestones for milestonesDao
            override suspend fun saveCallResults(items: List<Milestone>)
                = dao.insertMilestones(items)

            override fun shouldFetch(data: List<Milestone>?): Boolean
                = data == null || data.isEmpty() || forceRefresh

            //TODO: Create getMilestonesForRepository for milestonesDao
            override suspend fun loadFromDb(): List<Milestone>
                = dao.getMilestones()

            override fun createCallAsync(): Deferred<ApiResult<Milestone>>
                = datasource.fetchMilestonesForRepo(user, repo)
        }.build().asLiveData()
    }
}