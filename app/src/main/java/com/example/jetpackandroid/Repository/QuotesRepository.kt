package com.example.jetpackandroid.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jetpackandroid.API.QuoteService
import com.example.jetpackandroid.Models.QuoteList

class QuotesRepository(private val quoteService: QuoteService) {

    private val quotesLiveData = MutableLiveData<QuoteList> ()

    val quotes : LiveData<QuoteList>
    get() = quotesLiveData

    // iss live data ko viewModel observe krta hai

    suspend fun getQuotes(page: Int) {
        val result = quoteService.getQuotes(page)

        if (result?.body() != null) {
            quotesLiveData.postValue(result.body())

        }
    }
}