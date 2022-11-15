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
import com.example.jetpackandroid.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.util.Date


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val quoteAPI = RetrofitHelper.getInstance().create(QuotesAPI::class.java)

        GlobalScope.launch {
            val result = quoteAPI.getQuotes(1)


            if (result != null) {
                Log.d(Constants.TAG, result.body().toString())

                val quoteList = result.body()
                if (quoteList != null) {
                    quoteList.results.forEach {
                        Log.d(Constants.TAG, it.content )
                    }
                }

            }
        }



    }


}