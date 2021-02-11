package com.ss.pagination.util

import androidx.recyclerview.widget.DiffUtil
import com.ss.pagination.api.ApiService
import com.ss.pagination.model.Result
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constants {

    const val DEFAULT_PAGE_INDEX = 1
    const val DEFAULT_PAGE_SIZE = 20
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    const val API_KEY = "c549b0b6a42c2b56589e9be69b41897c"

    val apiService: ApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    val DIFFER_CALLBACK = object : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean =
            oldItem == newItem
    }
}