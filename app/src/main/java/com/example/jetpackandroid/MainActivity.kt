package com.example.jetpackandroid

import android.icu.number.Precision.increment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.i
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackandroid.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // BINDING SETUP
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // viewmodel
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // xml ka yha bhi define kran >>>>>>>>>>>>> NEW
        binding.mainViewModel = mainViewModel

        // observing live data - this is also not needed when using binding
        // bss lifecycle owner btana pdega
//        mainViewModel.quoteLiveData.observe(this, Observer {
//            binding.quoteText.text = it
//        })

        binding.lifecycleOwner = this
        // live data is lifecycle aware isliye usko btana pdta h h lifecycle owner kon hai

        // agr hum binding use krte h to
        // binding.mainViewModel = mainViewModel
        // binding.lifecycleWonwe = this

        // bbs ye 2 extra hote hai



        binding.counterBtn.setOnClickListener{
            mainViewModel.updateQuote()

        }


    }


}