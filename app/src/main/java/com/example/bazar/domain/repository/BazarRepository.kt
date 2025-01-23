package com.example.bazar.domain.repository

import com.example.bazar.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface BazarRepository {
    fun getBooksByCategory(category: String): Flow<List<Item>>

    fun searchBooks(query: String): Flow<List<Item>>
}