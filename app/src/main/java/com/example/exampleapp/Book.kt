package com.example.exampleapp

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Results(
    var totalItems:Int,
    @Json(name = "items") var items: List<Result>?):Parcelable

@Parcelize
data class Result(
    @Json(name = "volumeInfo") var book: Book?
):Parcelable

@Parcelize
data class Book (
    val title: String?,
    val authors: List<String>?,
    @Json(name = "imageLinks") val imageLinks:Img):Parcelable

@Parcelize
data class Img (var smallThumbnail:String, var thumbnail:String):Parcelable