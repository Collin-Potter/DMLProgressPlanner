package com.capotter.dmlprogressplanner.data.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.capotter.dmlprogressplanner.data.model.User
import com.capotter.dmlprogressplanner.data.persistence.User.UserDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserRepository(private val userDao: UserDao) {

    private var userList: LiveData<List<User>> = userDao.getUsers()

    fun getUsers(): LiveData<List<User>> {
        return userList
    }

    @WorkerThread
    suspend fun insertUser(user: User){
        userDao.insertUser(user)
    }
}