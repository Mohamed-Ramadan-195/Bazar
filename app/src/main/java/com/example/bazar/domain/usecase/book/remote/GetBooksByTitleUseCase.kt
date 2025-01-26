package com.example.bazar.domain.usecase.book.remote

import com.example.bazar.domain.model.Item
import com.example.bazar.domain.repository.BazarRepository
import kotlinx.coroutines.flow.Flow

class GetBooksByTitleUseCase (
    private val bazarRepository: BazarRepository
) {
    operator fun invoke (title: String) : Flow<List<Item>> {
        return bazarRepository.getBooksByCategory(title)
    }
}