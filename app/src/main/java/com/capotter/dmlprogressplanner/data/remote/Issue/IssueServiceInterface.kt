package com.capotter.dmlprogressplanner.data.remote.Issue

import com.capotter.dmlprogressplanner.data.model.Issue
import retrofit2.Call
import retrofit2.http.*

//TODO: dynamically determine owner, repo, and issue number for specific calls
interface IssueServiceInterface {
    @GET("/repos/:owner/:repo/issues/:issue_number")
    fun getSingleIssue() : Call<Issue>
    @GET("/repos/:owner/:repo/issues")
    fun getIssuesForRepository() : Call<Issue>
    @POST("/repos/:owner/:repo/issues")
    fun createAnIssue() : Call<Issue>
    @PATCH("/repos/:owner/:repo/issues/:issue_number")
    fun editIssue() : Call<Issue>
}