package com.capotter.dmlprogressplanner.ui.MilestonesActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//TODO: Create base factory class to eliminate boilerplate code
class MilestonesViewModelFactory(val userId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MilestonesActivityViewModel(userId) as T
    }
}