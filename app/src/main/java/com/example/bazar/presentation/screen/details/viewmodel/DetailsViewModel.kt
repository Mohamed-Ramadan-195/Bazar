package com.example.bazar.presentation.screen.details.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazar.domain.model.Item
import com.example.bazar.domain.usecase.book.base.BooksUseCases
import com.example.bazar.presentation.screen.details.view.DetailsEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val booksUseCases: BooksUseCases
) : ViewModel() {
    var sideEffect by mutableStateOf<String?>(null)
        private set

    fun onEvent(detailsEvent: DetailsEvent) {
        when (detailsEvent) {
            is DetailsEvent.OperationsBook -> {
                viewModelScope.launch {
                    val book = booksUseCases.getBookDetailsUseCase(detailsEvent.item.id)
                    if (book == null) {
                        insertBook(detailsEvent.item)
                    } else {
                        deleteBook(detailsEvent.item)
                    }
                }
            }
            is DetailsEvent.RemoveSideEffect -> {
                sideEffect = null
            }
        }
    }

    private suspend fun insertBook(item: Item) {
        booksUseCases.insertBookUseCase(item)
        sideEffect = "Book Saved"
    }

    private suspend fun deleteBook(item: Item) {
        booksUseCases.deleteBookUseCase(item)
        sideEffect = "Book Deleted"
    }
}