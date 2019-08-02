package com.capotter.dmlprogressplanner.data.remote.GitHubRepo

import com.capotter.dmlprogressplanner.data.model.GitHubRepository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubRepoServiceInterface {
    @GET("/users/{username}/repos")
    fun getRepos(
        @Query("username")username: String
    ) : Call<GitHubRepository>
}