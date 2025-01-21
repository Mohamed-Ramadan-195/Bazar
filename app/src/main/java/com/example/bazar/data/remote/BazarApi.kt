package com.example.bazar.data.remote

import com.example.bazar.data.remote.dto.BookCategory
import retrofit2.http.GET
import retrofit2.http.Query

interface BazarApi {
    @GET("books/v1/volumes")
    suspend fun getBooksByCategory (@Query("q") category: String) : BookCategory
}