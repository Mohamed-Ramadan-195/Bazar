package com.example.bazar.domain.usecase.book.local

import com.example.bazar.domain.model.Item
import com.example.bazar.domain.repository.BazarRepository

class GetBookDetailsUseCase (
    private val bazarRepository: BazarRepository
) {
    suspend operator fun invoke(id: String) : Item? {
        return bazarRepository.getBookDetails(id)
    }
}