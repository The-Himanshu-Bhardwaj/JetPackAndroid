package com.example.jetpackandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(Constants.TAG, "onCreate: activity")

        // attaching the observer

        lifecycle.addObserver(Observer())
    }

    override fun onResume() {
        super.onResume()
        Log.d(Constants.TAG, "onResume: activity")
    }

    override fun onPause() {
        super.onPause()
        Log.d(Constants.TAG, "onPause: activity")
    }

    override fun onStop() {
        super.onStop()
        Log.d(Constants.TAG, "onStop: activity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(Constants.TAG, "onDestroy: activity")
    }
}