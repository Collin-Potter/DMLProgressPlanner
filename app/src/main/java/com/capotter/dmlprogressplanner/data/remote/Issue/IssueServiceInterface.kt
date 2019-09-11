package com.capotter.dmlprogressplanner.data.remote.Issue

import com.capotter.dmlprogressplanner.data.model.ApiResult
import com.capotter.dmlprogressplanner.data.model.Issue
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.*

//TODO: dynamically determine owner, repo, and issue number for specific calls
interface IssueServiceInterface {
    @GET("/repos/{owner}/{repo}/issues")
    fun getIssuesForRepository(
        @Query("owner")owner: String,
        @Query("repo")repo: String
    ) : Deferred<ApiResult<Issue>>
}