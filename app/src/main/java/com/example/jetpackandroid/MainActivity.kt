package com.example.jetpackandroid

import android.icu.number.Precision.increment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.i
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    lateinit var textView : TextView
    lateinit var button: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        textView = findViewById(R.id.counterLabel)
        button = findViewById(R.id.counterBtn)

        CoroutineScope(Dispatchers.Main).launch {

            for (i in 1..10) {
                delay(1000)
                mainViewModel.counter = i
                mainViewModel.updateLiveData()
            }
        }

        // OBSERVER
        mainViewModel.factsLiveData.observe(this, Observer{
            textView.text = it

            // factslive data pe observer lga diya
            // jese hi data mein koi change hoga yha pe jo code likha hoga vo execute hoga

        })

        button.setOnClickListener{
//            mainViewModel.updateLiveData()
        }

    }


}