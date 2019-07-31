package com.capotter.dmlprogressplanner.data.remote.User

import com.capotter.dmlprogressplanner.data.model.User
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

//TODO: dynamically determine username for call
interface UserServiceInterface {
    @GET("/users/:username")
    fun getUser() : Call<User>
}