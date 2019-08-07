package com.capotter.dmlprogressplanner.data.persistence.User

import androidx.lifecycle.LiveData
import androidx.room.*
import com.capotter.dmlprogressplanner.data.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM users")
    fun getUsers(): LiveData<List<User>>

    @Query("SELECT * FROM users WHERE name LIKE :name LIMIT 1")
    fun getUserByName(name: String): User

    @Delete
    fun deleteUser(user: User): Int

    @Update
    fun updateUser(user: User): Int
}