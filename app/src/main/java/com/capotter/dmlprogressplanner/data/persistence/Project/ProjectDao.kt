package com.capotter.dmlprogressplanner.data.persistence.Project

import androidx.lifecycle.LiveData
import androidx.room.*
import com.capotter.dmlprogressplanner.data.model.Project

@Dao
interface ProjectDao {

    @Insert
    fun insertProject(project: Project): Long

    @Query("SELECT * FROM projects")
    fun getProjects(): LiveData<List<Project>>

    @Delete
    fun deleteProject(title: String): Long

    @Update
    fun updateProject(title: String, body: String): Long

}