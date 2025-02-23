package com.example.bazar.presentation.screen.my_book

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bazar.domain.model.Item
import com.example.bazar.presentation.common.BazarBookItem
import com.example.bazar.presentation.common.SpacerHeight
import com.example.bazar.presentation.common.BazarTextHeadline
import com.example.bazar.util.Dimen.MediumSpace

@Composable
fun MyBookScreen (
    navigateToDetails: (Item) -> Unit
) {
    val myBookViewModel: MyBookViewModel = hiltViewModel()
    val state = myBookViewModel.state.value

    MyBookScreen (
        myBookState = state,
        navigateToDetails = navigateToDetails
    )
}

@Composable
fun MyBookScreen (
    myBookState: MyBookState,
    navigateToDetails: (Item) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(MediumSpace)
            .statusBarsPadding()
    ) {
        SpacerHeight(MediumSpace)
        BazarTextHeadline("My Books")
        SpacerHeight(MediumSpace)
        LazyVerticalGrid (
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize()
        ) {
            items(count = myBookState.books.size) { item ->
                BazarBookItem (
                    item = myBookState.books[item],
                    onClick = { navigateToDetails(myBookState.books[item]) }
                )
            }
        }
    }
}
