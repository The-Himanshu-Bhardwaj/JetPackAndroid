package com.example.jetpackandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var counter = 0

    private val factsLiveDataObj = MutableLiveData<String>("this is a fact")

    // yha bss data ko livedata se enclose krdiya
    // ab main activity mein observer lga denge

    val factsLiveData : LiveData<String> = factsLiveDataObj

    // upr vaale ko prvate krdiya usko bss hum yha change kar paaye taaki
    // baki puri application iss vale object ko access kregi kyuki ye read only hai
    // upr vaale mein changes hum apne hisaab se krenge yha for eg
    // repository se data laa k facts live data obj mein store krdenge
    // isse security bdhti hai
    // ni to koi b change krdeta isko ya glti se hum hi chnage krde kya pta kyuki same sa naam h
    // isliye private krdiya


    suspend fun updateLiveData() {
        factsLiveDataObj.value = counter.toString()
    }
}