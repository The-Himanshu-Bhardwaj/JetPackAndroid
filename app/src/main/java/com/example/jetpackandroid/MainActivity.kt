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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    lateinit var quoteText : TextView
    lateinit var authorText : TextView
    lateinit var button: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // BINDING SETUP
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val quoteObj = Quote("Shri ShivayNamstubhyam", "someone")
        // yha se quote object bhej diya
        // xml mein pehle hi bta rkha h ki iss form mein data milega
        // data milte rhega vo set krta rhega
        binding.quote = quoteObj




//        quoteText = findViewById(R.id.quoteText) // no need to use this
//        authorText = findViewById(R.id.authorText) // same as above
    //        button = findViewById(R.id.counterBtn) / same as above



    }


}