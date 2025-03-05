package com.example.bazar.domain.repository

import com.example.bazar.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface BazarRepository {
    fun getBooksByCategory(category: String): Flow<List<Item>>

    fun searchBooks(query: String): Flow<List<Item>>

    suspend fun insertBook(item: Item)

    suspend fun deleteBook(item: Item)

    fun getBooksFavorite(): Flow<List<Item>>

    suspend fun getBookDetails(id: String): Item?
}