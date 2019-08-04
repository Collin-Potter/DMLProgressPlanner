package com.capotter.dmlprogressplanner.data.persistence.Project

import androidx.lifecycle.LiveData
import androidx.room.*
import com.capotter.dmlprogressplanner.data.model.Project

@Dao
interface ProjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProject(project: Project)

    @Query("SELECT * FROM projects")
    fun getProjects(): LiveData<List<Project>>

    @Query("SELECT * FROM projects WHERE name LIKE :name LIMIT 1")
    fun getProjectByName(name: String): Project

    @Delete
    fun deleteProject(project: Project): Int

    @Update
    fun updateProject(project: Project): Int

}