package com.capotter.dmlprogressplanner.ui.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.capotter.dmlprogressplanner.data.model.Milestone
import com.capotter.dmlprogressplanner.data.repository.MilestoneRepository
import com.capotter.dmlprogressplanner.data.repository.utils.Resource

class GetMilestoneListUseCase(private val repository: MilestoneRepository) {

    suspend operator fun invoke(forceRefresh: Boolean = false, login: String, repo: String): LiveData<Resource<List<Milestone>>> {
        return Transformations.map(repository.getMilestonesWithCache(forceRefresh, login, repo)) {

            it // Place here your specific logic actions (if any)

        }
    }

}