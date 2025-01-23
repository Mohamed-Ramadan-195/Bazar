package com.example.bazar.domain.repository

import com.example.bazar.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface BazarRepository {
    fun getBooksByCategory(category: String): Flow<List<Item>>

    // fun getBookById(id: String): Item
}