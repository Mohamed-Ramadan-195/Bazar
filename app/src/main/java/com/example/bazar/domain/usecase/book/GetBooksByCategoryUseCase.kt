package com.example.bazar.domain.usecase.book

import com.example.bazar.domain.model.Item
import com.example.bazar.domain.repository.BazarRepository
import kotlinx.coroutines.flow.Flow

class GetBooksByCategoryUseCase (
    private val bazarRepository: BazarRepository
) {
    operator fun invoke(category: String): Flow<List<Item>> {
        return bazarRepository.getBooksByCategory(category)
    }
}