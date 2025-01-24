package com.example.bazar.domain.usecase.book.local

import com.example.bazar.domain.model.Item
import com.example.bazar.domain.repository.BazarRepository

class DeleteBookUseCase (
    private val bazarRepository: BazarRepository
) {
    suspend operator fun invoke (item: Item) {
        bazarRepository.deleteBook(item)
    }
}