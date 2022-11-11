package com.example.jetpackandroid

import androidx.lifecycle.ViewModel

class MainViewModel(val initalValue : Int) : ViewModel() {

    // view model mein sirf data rkhte hai ya data pe kaam krte h
    // kisi view ka referene ni lete

    var count : Int = initalValue

    fun increment() {
        count++
    }
}