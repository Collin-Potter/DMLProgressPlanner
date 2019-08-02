package com.capotter.dmlprogressplanner.data.remote.Project

import com.capotter.dmlprogressplanner.data.model.Project
import retrofit2.Call
import retrofit2.http.*

//TODO: dynamically determine owner, repo, username, and project_id for specific calls
interface ProjectServiceInterface {

    @POST("/user/projects")
    fun createUserProject() : Call<Project>
    @GET("/users/{username}/projects")
    fun getUserProjects(
        @Query("username")username: String
    ) : Call<Project>

    @POST("/repos/{owner}/{repo}/projects")
    fun createRepositoryProject(
        @Query("owner")owner: String,
        @Query("repo")repo: String
    ) : Call<Project>
    @GET("/repos/{owner}/{repo}/projects")
    fun getRepositoryProjects(
        @Query("owner")owner: String,
        @Query("repo")repo: String
    ) : Call<Project>

    @GET("/projects/{project_id}")
    fun getProject(
        @Query("project_id")project_id: String
    ) : Call<Project>
    @PATCH("/projects/{project_id}")
    fun updateProject(
        @Query("project_id")project_id: String
    ) : Call<Project>
    @DELETE("/projects/{project_id}")
    fun deleteProject(
        @Query("project_id")project_id: String
    ) : Call<String>
}