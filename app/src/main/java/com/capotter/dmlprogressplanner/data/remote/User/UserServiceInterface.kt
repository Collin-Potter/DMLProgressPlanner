package com.capotter.dmlprogressplanner.data.remote.User

import com.capotter.dmlprogressplanner.data.model.User
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.*

interface UserServiceInterface {
    @GET("/users/{username}")
    fun getUser(@Path("username")username: String) : Deferred<User>
}