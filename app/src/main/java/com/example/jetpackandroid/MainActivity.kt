package com.example.jetpackandroid

import android.icu.number.Precision.increment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.i
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.jetpackandroid.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = QuoteDatabase.getDatabase(applicationContext).quoteDao()

        val repository = QuoteRepository(dao)

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        binding.postDesc.text = mainViewModel.getQuotes().toString()

        binding.counterBtn.setOnClickListener {

            val quote = Quote(0, "Shri SHivay NamastuBhyam", "someone")
            mainViewModel.insertQuote(quote)
            Toast.makeText(this, "done", Toast.LENGTH_SHORT)

        }

    }


}