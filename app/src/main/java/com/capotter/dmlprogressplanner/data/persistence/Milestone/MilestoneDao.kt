package com.capotter.dmlprogressplanner.data.persistence.Milestone

import androidx.lifecycle.LiveData
import androidx.room.*
import com.capotter.dmlprogressplanner.data.model.Milestone

@Dao
interface MilestoneDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMilestone(milestone: Milestone)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMilestones(milestones: List<Milestone>)

    @Query("SELECT * FROM milestones")
    fun getMilestones(): List<Milestone>

    @Query("SELECT * FROM milestones WHERE title LIKE :title LIMIT 1")
    fun getMilestoneByTitle(title: String): Milestone

    @Delete
    fun deleteMilestone(milestone: Milestone): Int

    @Update
    fun updateMilestone(milestone: Milestone): Int
}