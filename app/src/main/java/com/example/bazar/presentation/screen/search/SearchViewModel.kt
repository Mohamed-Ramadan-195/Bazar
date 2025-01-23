package com.example.bazar.presentation.screen.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazar.domain.usecase.book.BooksUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor (
    private val booksUseCases: BooksUseCases
) : ViewModel() {
    private var _searchState = mutableStateOf(SearchState())
    val searchState: State<SearchState> = _searchState

    fun onEvent(searchEvent: SearchEvent) {
        when (searchEvent) {
            is SearchEvent.UpdateSearchQuery -> {
                _searchState.value = searchState.value.copy(searchQuery = searchEvent.searchQuery)
            }

            is SearchEvent.SearchBooks -> {
                searchBooks()
            }
        }
    }

    private fun searchBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            booksUseCases.searchBooksUseCase(searchState.value.searchQuery)
                .catch { e ->
                    println("Error: ${e.message}")
                }
                .collect { books ->
                    if (books.isEmpty()) {
                        println("No books found")
                    }
                    _searchState.value = searchState.value.copy(books = books)
                }
        }
    }
}