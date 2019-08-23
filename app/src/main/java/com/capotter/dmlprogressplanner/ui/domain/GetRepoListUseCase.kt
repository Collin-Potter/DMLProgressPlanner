package com.capotter.dmlprogressplanner.ui.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.capotter.dmlprogressplanner.data.model.GitHubRepository
import com.capotter.dmlprogressplanner.data.repository.GitHubRepositoryRepository
import com.capotter.dmlprogressplanner.data.repository.UserRepository
import com.capotter.dmlprogressplanner.data.repository.utils.Resource

class GetRepoListUseCase(private val repository: GitHubRepositoryRepository) {

    suspend operator fun invoke(forceRefresh: Boolean = false, login: String): LiveData<Resource<List<GitHubRepository>>> {
        return Transformations.map(repository.getRepositoriesWithCache(forceRefresh, login)) {

            it // Place here your specific logic actions (if any)

        }
    }
}