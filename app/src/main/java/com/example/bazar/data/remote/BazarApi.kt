package com.example.bazar.data.remote

import com.example.bazar.data.remote.dto.Book
import com.example.bazar.util.Constant.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface BazarApi {
    @GET("books/v1/volumes")
    suspend fun getBooksByCategory (@Query("q") category: String) : Book

    @GET("books/v1/volumes")
    suspend fun searchBooks (
        @Query("q") query: String,
        @Query("filter") filter: String = "ebooks",
        @Query("key") key: String = API_KEY
    ) : Book
}