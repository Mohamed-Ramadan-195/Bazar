package com.example.bazar.presentation.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazar.domain.usecase.book.base.BooksUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (
    private val booksUseCases: BooksUseCases
) : ViewModel() {

    init {
        getBooksByCategory("subject:Programming")
        getBooksByCategory("subject:Education")
    }

    private var _state = mutableStateOf(BooksState())
    val state: State<BooksState> = _state

    private fun getBooksByCategory (category: String) {
        viewModelScope.launch {
            if (category == "subject:Programming") {
                booksUseCases.getBooksByCategoryUseCase(category)
                    .collect { books ->
                        _state.value = _state.value.copy(programmingBooks = books)
                    }
            } else if (category == "subject:Education") {
                booksUseCases.getBooksByCategoryUseCase(category)
                    .collect { books ->
                        _state.value = _state.value.copy(educationBooks = books)
                    }
            }
        }
    }
}