package com.capotter.dmlprogressplanner.data.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.capotter.dmlprogressplanner.data.model.Issue
import com.capotter.dmlprogressplanner.data.persistence.Issue.IssueDao
import kotlinx.coroutines.SupervisorJob

class IssueRepository(private val issueDao: IssueDao) {

    private var issueList: LiveData<List<Issue>> = issueDao.getIssues()

    fun getIssuesList(): LiveData<List<Issue>> {
        return issueList
    }

    @WorkerThread
    suspend fun insertIssue(issue: Issue){
        issueDao.insertIssue(issue)
    }
}