package com.capotter.dmlprogressplanner.data.remote.GitHubRepo

class GitHubRepoClient(private val gitHubRepositoryService: GitHubRepoServiceInterface) {

    fun fetchRepositories(user: String)
            = gitHubRepositoryService.getReposForOwner(user)

}