package com.capotter.dmlprogressplanner.data.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.capotter.dmlprogressplanner.data.model.User
import com.capotter.dmlprogressplanner.data.persistence.User.UserDao
import com.capotter.dmlprogressplanner.data.remote.User.UserDatasource
import com.capotter.dmlprogressplanner.data.repository.utils.NetworkBoundResource
import com.capotter.dmlprogressplanner.data.repository.utils.Resource
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

interface UserRepository {
    suspend fun getUserDetailWithCache(forceRefresh: Boolean = false, login: String): LiveData<Resource<User>>
}
class UserRepositoryImpl(private val userDao: UserDao,
                         private val datasource: UserDatasource) : UserRepository{

    override suspend fun getUserDetailWithCache(forceRefresh: Boolean, login: String): LiveData<Resource<User>>{
        return object : NetworkBoundResource<User, User>() {

            override fun processResponse(response: User): User
                = response

            override suspend fun saveCallResults(item: User)
                = userDao.insertUser(item)

            override fun shouldFetch(data: User?): Boolean
                = data == null
                    || data.name.isNullOrEmpty()
                    || forceRefresh

            override suspend fun loadFromDb(): User
                = userDao.getUserByName(login)

            override fun createCallAsync(): Deferred<User>
                = datasource.fetchUserDetails(login)

        }.build().asLiveData()
    }

}