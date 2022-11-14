package com.example.jetpackandroid

import androidx.lifecycle.LiveData

class QuoteRepository(private val quoteDAO: QuoteDAO) {

    fun getQuotes() : LiveData<List<Quote>> {
        return quoteDAO.getQuotes()
    }

    suspend fun insertQuote(quote: Quote) {
        quoteDAO.insertQuote(quote)
    }
}