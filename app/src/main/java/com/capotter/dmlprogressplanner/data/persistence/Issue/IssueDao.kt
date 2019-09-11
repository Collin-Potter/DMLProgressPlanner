package com.capotter.dmlprogressplanner.data.persistence.Issue

import androidx.lifecycle.LiveData
import androidx.room.*
import com.capotter.dmlprogressplanner.data.model.Issue

@Dao
interface IssueDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIssue(issue: Issue)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIssues(issues: List<Issue>)

    @Query("SELECT * FROM issues")
    fun getIssues(): List<Issue>

    @Query("SELECT * FROM issues WHERE title LIKE :title LIMIT 1")
    fun getIssueByTitle(title: String): Issue

    @Delete
    fun deleteIssue(issue: Issue): Int

    @Update
    fun updateIssue(issue: Issue): Int
}