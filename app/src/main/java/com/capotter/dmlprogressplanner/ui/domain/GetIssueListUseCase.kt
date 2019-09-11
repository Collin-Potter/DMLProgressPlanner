package com.capotter.dmlprogressplanner.ui.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.capotter.dmlprogressplanner.data.model.GitHubRepository
import com.capotter.dmlprogressplanner.data.model.Issue
import com.capotter.dmlprogressplanner.data.repository.IssueRepository
import com.capotter.dmlprogressplanner.data.repository.utils.Resource

class GetIssueListUseCase(private val repository: IssueRepository) {

    suspend operator fun invoke(forceRefresh: Boolean = false, login: String, repo: String): LiveData<Resource<List<Issue>>> {
        return Transformations.map(repository.getIssuesWithCache(forceRefresh, login, repo)) {

            it // Place here your specific logic actions (if any)

        }
    }
}