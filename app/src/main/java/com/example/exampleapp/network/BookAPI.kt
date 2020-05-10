package com.example.exampleapp.network

import com.example.exampleapp.Book
import com.example.exampleapp.Results
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private val URL = "https://www.googleapis.com/books/v1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(URL)
    .build()


interface BooksApiServ {
    @GET("volumes?q=android&maxResults=40")
  public suspend fun getBooks():
            Response<Results>
}

object BookAPI {
    val retrofitService : BooksApiServ by lazy {
        retrofit.create(BooksApiServ::class.java)
    }
}