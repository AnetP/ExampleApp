package com.example.exampleapp.detailBook

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exampleapp.Result

class DetailViewModel (selectedBook: com.example.exampleapp.Result, app: Application): AndroidViewModel(app) {

    private val _book = MutableLiveData<com.example.exampleapp.Result>()
    val book: LiveData<com.example.exampleapp.Result>
    get() = _book

    init {
        _book.value= selectedBook
    }
}
