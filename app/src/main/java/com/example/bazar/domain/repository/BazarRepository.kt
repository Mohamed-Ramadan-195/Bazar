package com.example.bazar.domain.repository

import com.example.bazar.data.remote.dto.Item
import kotlinx.coroutines.flow.Flow

interface BazarRepository {
    fun getBooksByCategory(category: String): Flow<List<Item>>
}