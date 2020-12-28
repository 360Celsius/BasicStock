package com.a360celsius.basicstock.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel():ViewModel() {
    val isSplashFinishedLoadingTickersData: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
}