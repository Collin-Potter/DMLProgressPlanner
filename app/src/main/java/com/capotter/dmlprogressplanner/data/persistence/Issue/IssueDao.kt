package com.capotter.dmlprogressplanner.data.persistence.Issue

import androidx.lifecycle.LiveData
import androidx.room.*
import com.capotter.dmlprogressplanner.data.model.Issue

@Dao
interface IssueDao {

    @Insert
    fun insertIssue(issue: Issue): Long

    @Query("SELECT * FROM issues")
    fun getIssues(): LiveData<List<Issue>>

    @Delete
    fun deleteIssue(title: String): Long

    @Update
    fun updateIssue(title: String, body: String): Long
}