package com.capotter.dmlprogressplanner.ui.ProjectsActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capotter.dmlprogressplanner.data.model.Project

class ProjectsActivityViewModel(val userId: Int) : ViewModel() {
    val projects = MutableLiveData<List<Project>>()

    init {
        //TODO: Retrieve list of projects based on userId after successful login via GitHub
    }
}