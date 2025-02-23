package com.example.bazar.presentation.screen.category.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bazar.domain.model.Item
import com.example.bazar.presentation.common.BazarBookItem
import com.example.bazar.presentation.common.BazarCategoryItem
import com.example.bazar.presentation.common.SpacerHeight
import com.example.bazar.presentation.common.BazarTextHeadline
import com.example.bazar.presentation.screen.category.state.Category
import com.example.bazar.presentation.screen.category.state.CategoryState
import com.example.bazar.presentation.screen.category.viewmodel.CategoryViewModel
import com.example.bazar.util.Dimen.MediumSpace

@Composable
fun CategoryScreen (
    navigateToDetails: (Item) -> Unit
) {
    val categoryViewModel: CategoryViewModel = hiltViewModel()
    val categoryState by categoryViewModel.categoryState.collectAsState()
    val subjectState by categoryViewModel.subjectState

    CategoryScreenContent (
        categoryState = categoryState,
        onClickCategory = { category -> categoryViewModel.onCategoryClick(category) },
        books = subjectState.subjects,
        navigateToDetails = navigateToDetails
    )
}

@Composable
fun CategoryScreenContent (
    categoryState: CategoryState,
    onClickCategory: (Category) -> Unit,
    books: List<Item>,
    navigateToDetails: (Item) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(all = MediumSpace)
    ) {
        SpacerHeight(MediumSpace)
        BazarTextHeadline(text = "Category")
        SpacerHeight(MediumSpace)
        LazyRow (
            modifier = Modifier.fillMaxWidth()
        ) {
            items (
                items = categoryState.categories,
                key = { currentCategory -> currentCategory.category }
            ) {
                BazarCategoryItem (
                    category = it,
                    onClick = onClickCategory
                )
            }
        }
        SpacerHeight(MediumSpace)
        LazyVerticalStaggeredGrid (
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier.fillMaxSize()
        ) {
            items(count = books.size) { item ->
                BazarBookItem (
                    item = books[item],
                    onClick = { navigateToDetails(books[item]) }
                )
            }
        }
    }
}