package com.capotter.dmlprogressplanner.ui.ProjectsActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//TODO: Create base factory class to eliminate boilerplate code
class ProjectsViewModelFactory(val userId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProjectsActivityViewModel(userId) as T
    }
}