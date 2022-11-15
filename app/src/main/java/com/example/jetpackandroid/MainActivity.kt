package com.example.jetpackandroid

import android.icu.number.Precision.increment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.i
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.jetpackandroid.API.QuoteService
import com.example.jetpackandroid.API.RetrofitHelper
import com.example.jetpackandroid.Repository.QuotesRepository
import com.example.jetpackandroid.ViewModels.MainViewModel
import com.example.jetpackandroid.ViewModels.MainViewModelFactory
import com.example.jetpackandroid.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.util.Date


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        // retrofit ka instance quote service mein bnaya hai
        val repository = QuotesRepository(quoteService)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository))
            .get(MainViewModel::class.java)


        mainViewModel.quotes.observe(this, Observer {
            Log.d(Constants.TAG, it.results.toString())
        })


    }


}