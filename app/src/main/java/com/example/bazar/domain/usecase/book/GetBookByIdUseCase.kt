package com.example.bazar.domain.usecase.book

import com.example.bazar.domain.repository.BazarRepository

class GetBookByIdUseCase (
    private val bazarRepository: BazarRepository
) {
//    operator fun invoke(id: String) : Item {
//        return bazarRepository.getBookById(id)
//    }
}