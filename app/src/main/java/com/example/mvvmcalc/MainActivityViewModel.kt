package com.example.mvvmcalc

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    var firstNumber = 0
    var secondNumber = 0
    var results = MutableLiveData<Int>()

    fun addition(){
        results.value = firstNumber + secondNumber
    }
}