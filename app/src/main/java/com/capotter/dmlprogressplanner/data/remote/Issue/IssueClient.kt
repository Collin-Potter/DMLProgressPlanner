package com.capotter.dmlprogressplanner.data.remote.Issue

class IssueClient (private val issueService: IssueServiceInterface) {

    fun fetchIssuesForRepo(user: String, repository: String)
            = issueService.getIssuesForRepository(user, repository)

}