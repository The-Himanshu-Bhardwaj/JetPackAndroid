package com.example.jetpackandroid

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Contact::class], version = 1)
/*
* yha pe entities ki array hai, ek se zyada table bhi ho skti hai isliye jitni hongi utni pass krenge
* */

@TypeConverters(Converter::class)

abstract class ContactDatabase: RoomDatabase() {

    abstract fun contactDao() : ContactDAO
    // function h ye contactDB return krta h bs
    // contact ek interface h so, no instance etc

    companion object {

        // migration

        val migration_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }

        }
        // 1 is current version, 2 is new version, these are passed above

        // volatile means agr bht saari threads h to jese hi instane ki value mein change hoga sbko pta lg jaega
        @Volatile
        private var INSTANCE : ContactDatabase? = null


        fun getDatabaseInstance(context: Context) : ContactDatabase {
            if (INSTANCE == null) {

                // synchronised means agr bht saari threads ek hi baar mein isko access krne lgi to vo prevent krdiya jaega
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ContactDatabase::class.java,
                        "contactDB").addMigrations(migration_1_2)
                        .build()
                }

            }
            return INSTANCE!!
        }
    }
}