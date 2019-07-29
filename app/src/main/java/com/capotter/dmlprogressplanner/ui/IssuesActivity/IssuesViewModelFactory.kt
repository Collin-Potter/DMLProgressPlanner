package com.capotter.dmlprogressplanner.ui.IssuesActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//TODO: Create base factory class to eliminate boilerplate code
class IssuesViewModelFactory(val userId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return IssuesActivityViewModel(userId) as T
    }
}