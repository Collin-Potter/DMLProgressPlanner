package com.capotter.dmlprogressplanner.ui.IssuesActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capotter.dmlprogressplanner.data.model.Issue

class IssuesActivityViewModel(val userId: Int) : ViewModel() {
    val issues = MutableLiveData<List<Issue>>()

    init {
        //TODO: Retrieve list of issues based on current user
    }
}