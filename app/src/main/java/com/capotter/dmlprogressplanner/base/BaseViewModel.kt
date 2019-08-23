package com.capotter.dmlprogressplanner.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capotter.dmlprogressplanner.util.Event

abstract class BaseViewModel: ViewModel() {

    //FOR ERROR HANDLER
    protected val _snackbarError = MutableLiveData<Event<Int>>()
    val snackbarError: LiveData<Event<Int>> get() = _snackbarError
}