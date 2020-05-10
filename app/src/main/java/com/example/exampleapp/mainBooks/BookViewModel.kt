package com.example.exampleapp.mainBooks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exampleapp.Book
import com.example.exampleapp.Results
import com.example.exampleapp.network.BookAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookViewModel : ViewModel() {
    private val _response = MutableLiveData<List<com.example.exampleapp.Result>>()
    val response: LiveData<List<com.example.exampleapp.Result>>
        get() = _response

    private val _responseStr = MutableLiveData<String>()
    val responseStr: LiveData<String>
        get() = _responseStr

    private val _navigToDetail = MutableLiveData<com.example.exampleapp.Result>()
    val navigtoDetail: LiveData<com.example.exampleapp.Result>
        get() = _navigToDetail




    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )


    init {

     getBooks()

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private fun getBooks() {


        coroutineScope.launch {

            try {
                var responBook = BookAPI.retrofitService.getBooks()
                if (responBook.isSuccessful) {
                    _response.value=responBook.body()!!.items
                   _responseStr.value=responBook.body()!!.items.toString()
                } else {
                    _responseStr.value="Failure"
                }
            } catch (e: Exception) {
                _responseStr.value="Failure " + e.message
            }
        }

    }

    fun displayDetail(book : com.example.exampleapp.Result){
        _navigToDetail.value=book
    }
    fun displayDetailNull(){
        _navigToDetail.value=null
    }


}