package com.example.bazar.presentation.screen.bookmark

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazar.domain.usecase.book.base.BooksUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor (
    private val booksUseCases: BooksUseCases
) : ViewModel() {
    private val _state = mutableStateOf(BookmarkState())
    val state : State<BookmarkState> = _state

    init {
        getBooksBookmarked()
    }

    private fun getBooksBookmarked() {
        viewModelScope.launch(Dispatchers.IO) {
            booksUseCases.getBooksBookmarkedUseCase()
                .catch {
                    e -> println("Error: ${e.message}")
                }
                .collect { books ->
                    if (books.isEmpty()) {
                        println("No books found")
                    }
                    _state.value = state.value.copy(books = books)
                }
        }
    }
}