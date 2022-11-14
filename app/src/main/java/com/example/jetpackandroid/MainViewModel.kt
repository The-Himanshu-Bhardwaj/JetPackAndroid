package com.example.jetpackandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.launch

class MainViewModel(private val quoteRepository: QuoteRepository): ViewModel() {

    // yha constructor k andr ek paramtere hai isliye ViewModelFactory is necessary to be made

    fun getQuotes() : LiveData<List<Quote>> {
       return quoteRepository.getQuotes()
    }

    fun insertQuote(quote: Quote) {
        viewModelScope.launch(Dispatchers.IO){
            quoteRepository.insertQuote(quote)

        }
    }

}