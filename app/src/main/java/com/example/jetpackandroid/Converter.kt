package com.example.jetpackandroid

import androidx.room.TypeConverter
import java.util.*

class Converter {

    // if room comes across a value that needs to be inserted and not supported by Room
    // it will look here in converters for a function that takes that DATA type and will convert it automatically

    @TypeConverter
    fun dateToLong(value : Date) : Long {
        return value.time
    }

    @TypeConverter
    fun longToDate(value : Long) : Date {
        return Date(value)
    }
}