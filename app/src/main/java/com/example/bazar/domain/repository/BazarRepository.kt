package com.example.bazar.domain.repository

import androidx.paging.PagingData
import com.example.bazar.data.remote.dto.category.Work
import kotlinx.coroutines.flow.Flow

interface BazarRepository {
    fun getBooksByCategory(category: String): Flow<PagingData<Work>>
}