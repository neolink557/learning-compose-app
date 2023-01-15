package com.example.learning.ui.main

import android.text.InputFilter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val auth: LiveData<Boolean> get() = _auth
    private var _auth = MutableLiveData<Boolean>()
    val launch: LiveData<Boolean> get() = _launch
    private var _launch = MutableLiveData<Boolean>()


    fun isAuth(isAuth:Boolean){
        _auth.postValue(isAuth)
    }
    fun hasLaunch(hLaunch:Boolean){
        _launch.postValue(hLaunch)
    }
}