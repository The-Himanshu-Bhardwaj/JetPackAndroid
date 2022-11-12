package com.example.jetpackandroid

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
/*
* yha pe entities ki array hai, ek se zyada table bhi ho skti hai isliye jitni hongi utni pass krenge
* */
abstract class ContactDatabase: RoomDatabase() {

    abstract fun contactDao() : ContactDAO
}