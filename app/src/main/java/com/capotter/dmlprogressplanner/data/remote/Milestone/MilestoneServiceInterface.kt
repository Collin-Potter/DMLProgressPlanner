package com.capotter.dmlprogressplanner.data.remote.Milestone

import com.capotter.dmlprogressplanner.data.model.Milestone
import retrofit2.Call
import retrofit2.http.*

//TODO: dynamically determine owner and repo for specific calls
interface MilestoneServiceInterface {
    @GET("/repos/:owner/:repo/milestones")
    fun getMilestones(
        @Query("owner")owner: String,
        @Query("repo")repo: String
    ) : Call<Milestone>
    @POST("/repos/:owner/:repo/milestones")
    fun postMilestone(
        @Query("owner")owner: String,
        @Query("repo")repo: String
    ) : Call<Milestone>
    @PUT("/repos/:owner/:repo/milestones")
    fun updateMilestone(
        @Query("owner")owner: String,
        @Query("repo")repo: String
    ) : Call<Milestone>
    @DELETE("/repos/:owner/:repo/milestones")
    fun deleteMilestone(
        @Query("owner")owner: String,
        @Query("repo")repo: String
    ) : Call<String>
}