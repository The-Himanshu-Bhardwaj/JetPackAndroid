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
        val recyclerView = findViewById<RecyclerView>(R.id.programmingList)
        val adapter = ProgrammingAdapter()

        val p1 = ProgrammingItems(1, "ajsdhb", "dsjh")
        val p2 = ProgrammingItems(2, "ajsdashb", "dsafdsfajh")
        val p3 = ProgrammingItems(3, "ajaaasdhb", "dsjadsfah")

        adapter.submitList(listOf(p1, p2, p3))

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.hasFixedSize()
        recyclerView.adapter = adapter

        CoroutineScope(Dispatchers.Main).launch {
            delay(4000)
            val p4 = ProgrammingItems(3, "ajaaasdhb", "dsjadsfah")
            val p5 = ProgrammingItems(4, "g", "dsaajh")
            val p6 = ProgrammingItems(5, "d", "dsja")

            adapter.submitList(listOf(p4, p5, p6))

        }



    }


}