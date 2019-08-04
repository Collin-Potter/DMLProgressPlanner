package com.capotter.dmlprogressplanner.data.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.capotter.dmlprogressplanner.data.model.Project
import com.capotter.dmlprogressplanner.data.persistence.Project.ProjectDao

class ProjectRepository(private val projectDao: ProjectDao) {

    private var projectList: LiveData<List<Project>> = projectDao.getProjects()

    fun getProjects(): LiveData<List<Project>>{
        return projectList
    }

    @WorkerThread
    suspend fun insertProject(project: Project){
        projectDao.insertProject(project)
    }
}