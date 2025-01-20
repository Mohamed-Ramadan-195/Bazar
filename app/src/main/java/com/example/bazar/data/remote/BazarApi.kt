package com.example.bazar.data.remote

import com.example.bazar.data.remote.dto.category.Subject
import retrofit2.http.GET
import retrofit2.http.Path

interface BazarApi {
    @GET("subjects/{category}.json")
    suspend fun getBooksByCategory (@Path("category") category: String) : Subject
}