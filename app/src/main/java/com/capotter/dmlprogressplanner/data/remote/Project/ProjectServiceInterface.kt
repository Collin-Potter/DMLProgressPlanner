package com.capotter.dmlprogressplanner.data.remote.Project

import com.capotter.dmlprogressplanner.data.model.Project
import retrofit2.Call
import retrofit2.http.*

//TODO: dynamically determine owner, repo, username, and project_id for specific calls
interface ProjectServiceInterface {

    @POST("/user/projects")
    fun createUserProject() : Call<Project>
    @GET("/users/:username/projects")
    fun getUserProjects() : Call<List<Project>>

    @POST("/repos/:owner/:repo/projects")
    fun createRepositoryProject() : Call<Project>
    @GET("/repos/:owner/:repo/projects")
    fun getRepositoryProjects() : Call<List<Project>>

    @GET("/projects/:project_id")
    fun getProject() : Call<Project>
    @PATCH("/projects/:project_id")
    fun updateProject() : Call<Project>
    @DELETE("/projects/:project_id")
    fun deleteProject() : Call<Project>
}