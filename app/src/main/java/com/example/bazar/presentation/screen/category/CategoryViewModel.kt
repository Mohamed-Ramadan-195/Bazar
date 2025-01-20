package com.example.bazar.presentation.screen.category

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.bazar.domain.usecase.book.CategoriesUseCases
import com.example.bazar.presentation.screen.category.state.Category
import com.example.bazar.presentation.screen.category.state.CategoryState
import com.example.bazar.presentation.screen.category.state.SubjectState
import com.example.bazar.util.Constant.PLACES
import com.example.bazar.util.Constant.SUBJECTS
import com.example.bazar.util.Constant.TIMES
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val categoriesUseCases: CategoriesUseCases
) : ViewModel() {
    private val _categoryState = MutableStateFlow(CategoryState())
    val categoryState = _categoryState.asStateFlow()

    init {
        getCategories(SUBJECTS)
    }

    fun getCategories(type: String) {
        when (type) {
            SUBJECTS -> {
                _categoryState.update {
                    it.copy(
                        categories = listOf(
                            Category("Gravitation", true),
                            Category("Cosmology"),
                            Category("Congresses"),
                            Category("Astrophysics"),
                            Category("Physics"),
                            Category("History"),
                            Category("Mathematics"),
                            Category("Fiction")
                        )
                    )
                }
            }
            PLACES -> {
                _categoryState.update {
                    it.copy(
                        categories = listOf (
                            Category("United States", true),
                            Category("England"),
                            Category("Germany"),
                            Category("France"),
                            Category("Africa"),
                            Category("California"),
                            Category("Poland"),
                            Category("Haiti")
                        )
                    )
                }
            }
            TIMES -> {
                _categoryState.update {
                    it.copy(
                        categories = listOf (
                            Category("18th century", true),
                            Category("19th century"),
                            Category("20th century"),
                            Category("21st century"),
                            Category("1950's"),
                            Category("0-1066"),
                            Category("Early works to 1800"),
                            Category("The Future")
                        )
                    )
                }
            }
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
    }

    val books = categoriesUseCases.getBooksByCategoryUseCase (
        "England"
    ).cachedIn(viewModelScope)

//    private var _subjectState = mutableStateOf(SubjectState())
//    val subjectState : State<SubjectState> = _subjectState
//
//    private fun getBooksByCategory(category: String) {
//        viewModelScope.launch {
//            categoriesUseCases.getBooksByCategoryUseCase(category).onEach {
//                _subjectState.value = _subjectState.value.copy(subjects = it)
//            }.collect { }
//        }
//    }
}