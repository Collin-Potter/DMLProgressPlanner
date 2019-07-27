package com.capotter.dmlprogressplanner.data.persistence.Milestone

import androidx.lifecycle.LiveData
import androidx.room.*
import com.capotter.dmlprogressplanner.data.model.Milestone

@Dao
interface MilestoneDao {

    @Insert
    fun insertMilestone(milestone: Milestone): Long

    @Query("SELECT * FROM milestones")
    fun getMilestones(): LiveData<List<Milestone>>

    @Delete
    fun deleteMilestone(title: String): Long

    @Update
    fun updateMilestone(title: String, body: String): Long
}