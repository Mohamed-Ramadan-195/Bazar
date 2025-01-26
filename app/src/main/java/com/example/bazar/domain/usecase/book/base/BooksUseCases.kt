package com.example.bazar.domain.usecase.book.base

import com.example.bazar.domain.usecase.book.local.DeleteBookUseCase
import com.example.bazar.domain.usecase.book.local.GetBookDetailsUseCase
import com.example.bazar.domain.usecase.book.local.GetBooksBookmarkedUseCase
import com.example.bazar.domain.usecase.book.local.InsertBookUseCase
import com.example.bazar.domain.usecase.book.remote.GetBooksByCategoryUseCase
import com.example.bazar.domain.usecase.book.remote.GetBooksByTitleUseCase
import com.example.bazar.domain.usecase.book.remote.SearchBooksUseCase

data class BooksUseCases (
    val getBooksByCategoryUseCase: GetBooksByCategoryUseCase,
    val searchBooksUseCase: SearchBooksUseCase,
    val insertBookUseCase: InsertBookUseCase,
    val deleteBookUseCase: DeleteBookUseCase,
    val getBooksBookmarkedUseCase: GetBooksBookmarkedUseCase,
    val getBookDetailsUseCase: GetBookDetailsUseCase,
    val getBooksByTitleUseCase: GetBooksByTitleUseCase
)