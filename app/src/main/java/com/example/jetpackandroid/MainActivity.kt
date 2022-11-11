package com.example.jetpackandroid

import android.icu.number.Precision.increment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var textView : TextView
    lateinit var counterBtn : Button

    lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel()::class.java)

        textView = findViewById(R.id.counterLabel)
        counterBtn = findViewById(R.id.counterBtn)
        setText()



        counterBtn.setOnClickListener{
            mainViewModel.increment()
            setText()
        }

        // yha sirf button click vgerah handle hore hai bss data to viewmodel se aara h

    }



    fun setText() {
        textView.text = mainViewModel.count.toString()

    }


}