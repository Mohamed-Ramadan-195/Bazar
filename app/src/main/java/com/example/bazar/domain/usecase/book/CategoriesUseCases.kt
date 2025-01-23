package com.example.bazar.domain.usecase.book

data class CategoriesUseCases (
    val getBooksByCategoryUseCase: GetBooksByCategoryUseCase,
    val getBookByIdUseCase: GetBookByIdUseCase
)