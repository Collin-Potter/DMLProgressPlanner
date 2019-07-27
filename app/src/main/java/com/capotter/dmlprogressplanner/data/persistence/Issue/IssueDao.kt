package com.capotter.dmlprogressplanner.data.persistence.Issue

import androidx.lifecycle.LiveData
import androidx.room.*
import com.capotter.dmlprogressplanner.data.model.Issue

@Dao
interface IssueDao {

    @Insert
    fun insertIssue(issue: Issue)

    @Query("SELECT * FROM issues")
    fun getIssues(): LiveData<List<Issue>>

    @Query("SELECT * FROM issues WHERE title LIKE :title LIMIT 1")
    fun getIssueByTitle(title: String): Issue

    @Delete
    fun deleteIssue(issue: Issue): Int

    @Update
    fun updateIssue(issue: Issue): Int
}