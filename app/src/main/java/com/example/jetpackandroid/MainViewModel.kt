package com.example.jetpackandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val quoteLiveData = MutableLiveData("a sentence")

    fun updateQuote() {
        quoteLiveData.value = "another sentence"

    }

}