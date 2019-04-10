package com.zestworks.androidrepository

import android.arch.lifecycle.ViewModel;

class ListingViewModel(private val repository: Repository) : ViewModel() {

    override fun onCleared() {
        super.onCleared()
        repository.resetSharedPref()
    }

    fun editSharedPref() {
        repository.editSharedPref()
    }
}
