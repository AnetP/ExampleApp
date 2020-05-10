package com.example.exampleapp.detailBook

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class DetailViewModelFactory(
        private val book: com.example.exampleapp.Result,
        private val application: Application) : ViewModelProvider.Factory {
        @Suppress("unchecked")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
                return DetailViewModel(book, application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel")
        }
    }

