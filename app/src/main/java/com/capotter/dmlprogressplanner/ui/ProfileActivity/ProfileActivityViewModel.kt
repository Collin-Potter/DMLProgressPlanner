package com.capotter.dmlprogressplanner.ui.ProfileActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capotter.dmlprogressplanner.data.model.User

class ProfileActivityViewModel(val userId: Int) : ViewModel() {
    val user = MutableLiveData<User>()

    init {
        //TODO: Get user by userId and pass in necessary info
    }
}