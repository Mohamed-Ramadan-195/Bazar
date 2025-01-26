package com.example.bazar.presentation.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazar.domain.usecase.book.base.BooksUseCases
import com.example.bazar.presentation.screen.category.state.SubjectState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (
    private val booksUseCases: BooksUseCases
) : ViewModel() {
    private var _state = mutableStateOf(SubjectState())
    val state : State<SubjectState> = _state

    init {
        getRandomBooks("intitle:${generateRandomTitle()}")
    }

    private fun generateRandomTitle() : String {
        val titles = listOf(
            "the", "flowers",
            "api", "family",
            "love", "business",
            "computer", "sport",
            "fun", "world", "art",
        )
        return titles.random()
    }

    private fun getRandomBooks(title: String) {
        viewModelScope.launch(Dispatchers.IO) {
            booksUseCases.getBooksByTitleUseCase(title)
                .catch {
                    e -> println("Error: ${e.message}")
                }
                .collect { books ->
                    if (books.isEmpty()) {
                        println("No books found")
                    } else {
                        println("Books found")
                    }
                    _state.value = _state.value.copy(subjects = books)
                }
        }
    }
}