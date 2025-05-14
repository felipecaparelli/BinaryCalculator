package com.example.binarycalculator.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _numberInput = MutableLiveData<Int>().apply {
        value = 0
    }
    val numberInput: LiveData<Int> = _numberInput

}