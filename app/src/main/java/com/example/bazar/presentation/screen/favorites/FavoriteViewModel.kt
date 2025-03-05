package com.example.bazar.presentation.screen.favorites

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazar.domain.model.Item
import com.example.bazar.domain.usecase.book.base.BooksUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor (
    private val booksUseCases: BooksUseCases
) : ViewModel() {
    var sideEffect by mutableStateOf<String?>(null)
        private set

    var favoriteBooks by mutableStateOf(setOf<String>())
        private set

    init {
        getBooksFavorite()
    }

    fun onEvent(favoriteEvent: FavoriteEvent) {
        when (favoriteEvent) {
            is FavoriteEvent.OperationsInBook -> {
                viewModelScope.launch {
                    val book = booksUseCases.getBookDetailsUseCase(favoriteEvent.item.id)
                    if (book == null) {
                        insertBook(favoriteEvent.item)
                    } else {
                        deleteBook(favoriteEvent.item)
                    }
                }
            }

            is FavoriteEvent.RemoveSideEffect -> {
                sideEffect = null
            }
        }
    }

    private suspend fun insertBook(item: Item) {
        booksUseCases.insertBookUseCase(item)
        favoriteBooks = favoriteBooks + item.id
        sideEffect = "Book Saved"
    }

    private suspend fun deleteBook(item: Item) {
        booksUseCases.deleteBookUseCase(item)
        favoriteBooks = favoriteBooks - item.id
        sideEffect = "Book Deleted"
    }

    // ------------------------------- //

    private val _state = mutableStateOf(FavoriteState())
    val state : State<FavoriteState> = _state

    private fun getBooksFavorite() {
        viewModelScope.launch {
            booksUseCases.getBooksFavoriteUseCase()
                .collect { books ->
                    _state.value = state.value.copy(books = books)
                    favoriteBooks = books.map { it.id }.toSet()
                }
        }
    }
}