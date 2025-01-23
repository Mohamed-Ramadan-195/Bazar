package com.example.bazar.data.remote

import com.example.bazar.data.remote.dto.BookCategory
import com.example.bazar.domain.model.Item
import retrofit2.http.GET
import retrofit2.http.Query

interface BazarApi {
    @GET("books/v1/volumes")
    suspend fun getBooksByCategory (@Query("q") category: String) : BookCategory

    @GET("books/v1/volumes/{id}")
    fun getBookById (@Query("id") id: String) : Item
}