package com.example.bazar.domain.usecase.book.local

import com.example.bazar.domain.repository.BazarRepository

class GetBooksBookmarkedUseCase (
    private val bazarRepository: BazarRepository
) {
    operator fun invoke() = bazarRepository.getBooksBookmarked()
}