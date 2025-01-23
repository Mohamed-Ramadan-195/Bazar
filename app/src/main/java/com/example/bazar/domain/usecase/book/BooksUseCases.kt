package com.example.bazar.domain.usecase.book

data class BooksUseCases (
    val getBooksByCategoryUseCase: GetBooksByCategoryUseCase,
    val searchBooksUseCase: SearchBooksUseCase
)