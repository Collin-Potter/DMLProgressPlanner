package com.capotter.dmlprogressplanner.data.persistence.User

import androidx.lifecycle.LiveData
import androidx.room.*
import com.capotter.dmlprogressplanner.data.model.User

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User): Long

    @Query("SELECT * FROM users")
    fun getUsers(): LiveData<List<User>>

    @Delete
    fun deleteUser(title: String): Long

    @Update
    fun updateUser(title: String): Long
}