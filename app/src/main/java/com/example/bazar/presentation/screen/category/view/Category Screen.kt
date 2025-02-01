package com.example.bazar.presentation.screen.category.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bazar.domain.model.Item
import com.example.bazar.presentation.common.BazarBookItem
import com.example.bazar.presentation.common.BazarCategoryItem
import com.example.bazar.presentation.common.BazarSpacerHeight
import com.example.bazar.presentation.common.BazarTextHeadline
import com.example.bazar.presentation.screen.category.state.Category
import com.example.bazar.presentation.screen.category.state.CategoryState
import com.example.bazar.util.Dimen.MediumSpace

@Composable
fun CategoryScreen (
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
        BazarSpacerHeight(MediumSpace)
        BazarTextHeadline (text = "Category")
        BazarSpacerHeight(MediumSpace)
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
        BazarSpacerHeight(MediumSpace)
        LazyVerticalGrid (
            columns = GridCells.Fixed(2),
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