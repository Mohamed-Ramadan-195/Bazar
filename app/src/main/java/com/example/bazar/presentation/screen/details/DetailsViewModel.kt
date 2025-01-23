package com.example.bazar.presentation.screen.details

import androidx.lifecycle.ViewModel
import com.example.bazar.domain.model.Item
import com.example.bazar.domain.usecase.book.CategoriesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor (
    private val categoriesUseCases: CategoriesUseCases
) : ViewModel() {
    private val _detailsState = MutableStateFlow<Item?>(null)
    val detailsState : StateFlow<Item?> = _detailsState

//    fun getBookById(id: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            val item = categoriesUseCases.getBookByIdUseCase(id)
//            _detailsState.update { item }
//        }
//    }
}