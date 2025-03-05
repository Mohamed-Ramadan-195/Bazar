package com.example.bazar.domain.usecase.book.local

import com.example.bazar.domain.repository.BazarRepository

class GetBooksFavoriteUseCase (
    private val bazarRepository: BazarRepository
) {
    operator fun invoke() = bazarRepository.getBooksFavorite()
}