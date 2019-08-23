package com.capotter.dmlprogressplanner.data.remote.User

class UserDatasource(private val userService: UserServiceInterface) {

    fun fetchUserDetails(login: String) =
        userService.getUser(login)

}