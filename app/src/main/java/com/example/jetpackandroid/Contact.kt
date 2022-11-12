package com.example.jetpackandroid

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "Contact")
data class Contact(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val phone: String,
    val dateCreated: Date,
    val isActive : Int
)
