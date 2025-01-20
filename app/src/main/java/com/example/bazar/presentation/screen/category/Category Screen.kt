package com.example.bazar.presentation.screen.category

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.bazar.data.remote.dto.category.Work
import com.example.bazar.presentation.common.BazarBookItem
import com.example.bazar.presentation.common.BazarCategoryItem
import com.example.bazar.presentation.common.BazarList
import com.example.bazar.presentation.common.BazarSpacerHeight
import com.example.bazar.presentation.common.BazarTextHeadline
import com.example.bazar.presentation.screen.category.state.Category
import com.example.bazar.presentation.screen.category.state.CategoryState
import com.example.bazar.presentation.screen.category.state.SubjectState
import com.example.bazar.ui.theme.BazarTheme
import com.example.bazar.util.Constant.PLACES
import com.example.bazar.util.Constant.SUBJECTS
import com.example.bazar.util.Constant.TIMES
import com.example.bazar.util.Dimen.MediumSpace
import com.example.bazar.util.Dimen.SmallSpace

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun CategoryScreen (
    viewModel: CategoryViewModel = hiltViewModel()
) {
    val categoryState by viewModel.categoryState.collectAsState()
    // val subjectState = viewModel.subjectState.value
    // val errorMessage by viewModel.errorMessage.collectAsState()
    val categoriesTypes = listOf(SUBJECTS, PLACES, TIMES)
    // viewModel.getBooksByCategory("20th century")
    val works = viewModel.books.collectAsLazyPagingItems()

    CategoryScreenContent(
        categoryState = categoryState,
        onClickCategory = { category -> viewModel.onCategoryClick(category) },
        onClickCategoryType = { category -> viewModel.getCategories(category) },
        categoriesTypes = categoriesTypes,
        works = works
        // subjectState = subjectState,
        // errorMessage = errorMessage
    )
}

@Composable
fun CategoryScreenContent (
    categoryState: CategoryState,
    works: LazyPagingItems<Work>,
    // subjectState: SubjectState,
    // errorMessage: String?,
    onClickCategory: (Category) -> Unit,
    onClickCategoryType: (String) -> Unit,
    categoriesTypes: List<String>
) {
    var expanded by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(all = SmallSpace)
            .statusBarsPadding()
    ) {
        Row (
            modifier = Modifier.fillMaxWidth().padding(horizontal = SmallSpace),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BazarTextHeadline (text = "Category")
            Box {
                IconButton(onClick = { expanded = true }) {
                    Icon (
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "more menu"
                    )
                }

                DropdownMenu (
                    modifier = Modifier.background(color = Color.White),
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    categoriesTypes.forEach { categoryType ->
                        DropdownMenuItem(
                            text = { Text(categoryType) },
                            onClick = {
                                onClickCategoryType(categoryType)
                                expanded = false
                            }
                        )
                    }
                }
            }
        }
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
        BazarList(
            modifier = Modifier.padding(horizontal = 24.dp),
            books = works
        )
//        if (errorMessage != null) {
//            Text(text = "Error: $errorMessage") // Show error
//        } else if (subjectState.isEmpty()) {
//            Text(text = "No books available.") // Show empty state
//        } else {
//            LazyColumn {
//                items(subjectState) { book ->
//                    Text(text = book.title)
//                }
//            }
//        }

//        val books = subjectState.subjects
//        Toast.makeText (
//            LocalContext.current,
//            "books $books",
//            Toast.LENGTH_LONG
//        ).show()
    }
}

@Composable
@Preview(showBackground = true)
fun CategoryScreenPreview() {
    BazarTheme {
        CategoryScreen()
    }
}