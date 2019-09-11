package com.capotter.dmlprogressplanner.data.remote.GitHubRepo

import com.capotter.dmlprogressplanner.data.model.ApiResult
import com.capotter.dmlprogressplanner.data.model.GitHubRepository
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubRepoServiceInterface {
    @GET("/users/{username}/repos")
    fun getReposForOwner(
        @Query("username")username: String
    ) : Deferred<ApiResult<GitHubRepository>>
}