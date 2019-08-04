package com.capotter.dmlprogressplanner.data.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.capotter.dmlprogressplanner.data.model.Milestone
import com.capotter.dmlprogressplanner.data.persistence.Milestone.MilestoneDao

class MilestoneRepository(private val milestoneDao: MilestoneDao) {

    private var milestoneList: LiveData<List<Milestone>> = milestoneDao.getMilestones()

    fun getMilestones(): LiveData<List<Milestone>>{
        return milestoneList
    }

    @WorkerThread
    suspend fun insertMilestone(milestone: Milestone){
        milestoneDao.insertMilestone(milestone)
    }
}