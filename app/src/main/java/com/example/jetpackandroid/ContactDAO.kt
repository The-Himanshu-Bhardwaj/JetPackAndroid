package com.example.jetpackandroid

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface ContactDAO {

    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contact")
    fun getContact(): LiveData<List<Contact>>

    // room live data ko default background thread pe run krta hai
    // isliye isko alg se suspend likhne ki zrurt nhi hai
}