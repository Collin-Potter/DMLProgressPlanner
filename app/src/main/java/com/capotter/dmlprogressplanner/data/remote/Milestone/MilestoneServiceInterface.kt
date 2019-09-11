package com.capotter.dmlprogressplanner.data.remote.Milestone

import com.capotter.dmlprogressplanner.data.model.ApiResult
import com.capotter.dmlprogressplanner.data.model.Milestone
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.*

//TODO: dynamically determine owner and repo for specific calls
interface MilestoneServiceInterface {
    @GET("/repos/{owner}/{repo}/milestones")
    fun getMilestonesForRepository(
        @Query("owner")owner: String,
        @Query("repo")repo: String
    ) : Deferred<ApiResult<Milestone>>
}