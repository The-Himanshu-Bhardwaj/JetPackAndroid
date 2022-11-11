package com.example.jetpackandroid

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class Observer : LifecycleObserver {

     /**
      *
      * extends LifecycleObserver
     create your own methods and annotate with lifecycle events like Event.ON_CREATE
     we have already attached this observer to our Main activity
      now main activity will notify this observer for all the changes of lifecycle events

      coz this is a lifecycleobserver,

      *********
      * creation k phase mein activity pehle  create hoti h then observer k event invoke hote hai
      *
      * destruction phase mein pehle observer k method call honge then acitvity k
      * **********

      */



    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.d(Constants.TAG, "onCreate: OBSERVER")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.d(Constants.TAG, "onResume: OBSERVER")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.d(Constants.TAG, "onPause: OBSERVER")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.d(Constants.TAG, "onStop: OBSERVER")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.d(Constants.TAG, "onDestroy: OBSERVER")
    }
}