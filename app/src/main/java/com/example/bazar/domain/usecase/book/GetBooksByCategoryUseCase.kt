package com.example.bazar.domain.usecase.book

import androidx.paging.PagingData
import com.example.bazar.data.remote.dto.category.Work
import com.example.bazar.domain.repository.BazarRepository
import kotlinx.coroutines.flow.Flow

class GetBooksByCategoryUseCase (
    private val bazarRepository: BazarRepository
) {
    operator fun invoke(category: String): Flow<PagingData<Work>> {
        return bazarRepository.getBooksByCategory(category)
    }
}