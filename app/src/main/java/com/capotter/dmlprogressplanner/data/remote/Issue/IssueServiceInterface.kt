package com.capotter.dmlprogressplanner.data.remote.Issue

import com.capotter.dmlprogressplanner.data.model.Issue
import retrofit2.Call
import retrofit2.http.*

//TODO: dynamically determine owner, repo, and issue number for specific calls
interface IssueServiceInterface {
    @GET("/repos/:owner/:repo/issues/:issue_number")
    fun getSingleIssue(
        @Query("owner")owner: String,
        @Query("repo")repo: String,
        @Query("issue_number")issue_number: String
    ) : Call<Issue>
    @GET("/repos/:owner/:repo/issues")
    fun getIssuesForRepository(
        @Query("owner")owner: String,
        @Query("repo")repo: String
    ) : Call<Issue>
    @POST("/repos/:owner/:repo/issues")
    fun createAnIssue(
        @Query("owner")owner: String,
        @Query("repo")repo: String
    ) : Call<Issue>
    @PATCH("/repos/:owner/:repo/issues/:issue_number")
    fun editIssue(
        @Query("owner")owner: String,
        @Query("repo")repo: String,
        @Query("issue_number")issue_number: String
    ) : Call<Issue>
}