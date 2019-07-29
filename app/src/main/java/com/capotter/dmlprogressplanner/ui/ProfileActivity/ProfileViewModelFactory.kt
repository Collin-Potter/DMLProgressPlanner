package com.capotter.dmlprogressplanner.ui.ProfileActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//TODO: Create base factory class to eliminate boilerplate code
class ProfileViewModelFactory(val userId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileActivityViewModel(userId) as T
    }
}