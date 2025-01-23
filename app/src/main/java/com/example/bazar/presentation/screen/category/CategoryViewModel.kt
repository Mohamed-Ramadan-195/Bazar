package com.example.bazar.presentation.screen.category

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazar.domain.usecase.book.CategoriesUseCases
import com.example.bazar.presentation.screen.category.state.Category
import com.example.bazar.presentation.screen.category.state.CategoryState
import com.example.bazar.presentation.screen.category.state.SubjectState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor (
    private val categoriesUseCases: CategoriesUseCases
) : ViewModel() {
    private val _categoryState = MutableStateFlow(CategoryState())
    val categoryState = _categoryState.asStateFlow()

    init {
        getCategories()
        getBooksByCategory("subject:Science")
    }

    private fun getCategories() {
        _categoryState.update {
            it.copy(
                categories = listOf(
                    Category("Science", true),
                    Category("Programming"),
                    Category("Education"),
                    Category("Language"),
                    Category("Law"),
                    Category("Business & Economics"),
                    Category("High schools"),
                    Category("Computer Security"),
                    Category("History"),
                    Category("Biography & Autobiography"),
                )
            )
        }
    }

    fun onCategoryClick(selectedCategory: Category) {
        _categoryState.update { currentState ->
            currentState.copy (
                categories = currentState.categories.map {
                    if (it.category == selectedCategory.category) {
                        it.copy(
                            isSelected = true,
                            textColor = Color.Red
                        )
                    } else {
                        it.copy(
                            isSelected = false,
                            textColor = Color.Gray
                        )
                    }
                }
            )
        }
        getBooksByCategory("subject:${selectedCategory.category}")
    }

    private var _subjectState = mutableStateOf(SubjectState())
    val subjectState: State<SubjectState> = _subjectState

    private fun getBooksByCategory(category: String) {
        viewModelScope.launch {
            categoriesUseCases.getBooksByCategoryUseCase(category)
                .catch { e ->
                    println("Error: ${e.message}")
                }
                .collect { books ->
                    if (books.isEmpty()) {
                        println("No books found for category: $category")
                    } else {
                        println("Books found for category: $category")
                    }
                    _subjectState.value = _subjectState.value.copy(subjects = books)
                }
        }
    }
}