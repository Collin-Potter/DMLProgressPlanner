package com.capotter.dmlprogressplanner.data.remote.Milestone

import com.capotter.dmlprogressplanner.data.model.Milestone
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

//TODO: dynamically determine owner and repo for specific calls
interface MilestoneServiceInterface {
    @GET("/repos/:owner/:repo/milestones")
    fun getMilestones() : Call<List<Milestone>>
    @POST("/repos/:owner/:repo/milestones")
    fun postMilestone() : Call<Milestone>
    @PUT("/repos/:owner/:repo/milestones")
    fun updateMilestone() : Call<Milestone>
    @DELETE("/repos/:owner/:repo/milestones")
    fun deleteMilestone() : Call<Milestone>
}