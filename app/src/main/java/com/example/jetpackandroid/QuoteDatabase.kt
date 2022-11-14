package com.example.jetpackandroid

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quote::class], version = 1)

abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quoteDao() : QuoteDAO

    companion object{
        private var INSTANCE : QuoteDatabase? = null

        fun getDatabase(context: Context) : QuoteDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        QuoteDatabase::class.java, "quote_db")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }

}