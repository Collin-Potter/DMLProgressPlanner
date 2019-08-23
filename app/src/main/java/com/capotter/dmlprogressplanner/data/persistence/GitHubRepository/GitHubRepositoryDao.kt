package com.capotter.dmlprogressplanner.data.persistence.GitHubRepository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.capotter.dmlprogressplanner.data.model.GitHubRepository

@Dao
interface GitHubRepositoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRepo(repo: GitHubRepository)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRepos(repos: List<GitHubRepository>)

    @Query("SELECT * FROM github_repositories")
    fun getRepos(): List<GitHubRepository>

    @Query("SELECT * FROM github_repositories WHERE name LIKE :name LIMIT 1")
    fun getRepoByName(name: String): GitHubRepository

    @Delete
    fun deleteRepo(repo: GitHubRepository): Int

    @Update
    fun updateRepo(repo: GitHubRepository): Int
}