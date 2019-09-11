package com.capotter.dmlprogressplanner.data.remote.Milestone

class MilestoneClient (private val milestoneService: MilestoneServiceInterface) {

    fun fetchMilestonesForRepo(user: String, repository: String)
        = milestoneService.getMilestonesForRepository(user, repository)
}