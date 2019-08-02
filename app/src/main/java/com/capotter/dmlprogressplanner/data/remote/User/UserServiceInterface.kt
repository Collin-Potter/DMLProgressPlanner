package com.capotter.dmlprogressplanner.data.remote.User

import com.capotter.dmlprogressplanner.data.model.User
import retrofit2.Call
import retrofit2.http.*

//TODO: dynamically determine username for call
interface UserServiceInterface {
    @GET("/users/{username}")
    fun getUser(
        @Query("username")username: String
    ) : Call<String>
}