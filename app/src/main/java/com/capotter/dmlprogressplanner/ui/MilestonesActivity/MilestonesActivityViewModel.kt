package com.capotter.dmlprogressplanner.ui.MilestonesActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capotter.dmlprogressplanner.data.model.Milestone

class MilestonesActivityViewModel(val userId: Int) : ViewModel() {
    val milestones = MutableLiveData<List<Milestone>>()

    init {
        //TODO: Retrieve milestones based on logged in user
    }
}