package com.example.bazar.presentation.screen.bookmark

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
import com.example.bazar.R
import com.example.bazar.presentation.common.BazarBookItem
import com.example.bazar.presentation.common.SpacerHeight
import com.example.bazar.presentation.common.BazarTextHeadline
import com.example.bazar.presentation.common.EmptyScreen
import com.example.bazar.util.Dimen.MediumSpace

@Composable
fun BookmarkScreen (
    navigateToDetails: (Item) -> Unit
) {
    val bookmarkViewModel: BookmarkViewModel = hiltViewModel()
    val state = bookmarkViewModel.state.value

    BookmarkScreenContent (
        bookmarkState = state,
        navigateToDetails = navigateToDetails
    )
}

@Composable
fun BookmarkScreenContent (
    bookmarkState: BookmarkState,
    navigateToDetails: (Item) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(MediumSpace)
            .statusBarsPadding()
    ) {
        // No bookmarked books
        if (bookmarkState.books.isEmpty()) {
            EmptyScreen (
                raw = R.raw.bookmark,
                title = "No bookmarked books",
                subtitle = "You haven't bookmarked any books yet"
            )
        }

        // Display bookmarked books
        SpacerHeight(MediumSpace)
        BazarTextHeadline("Bookmark")
        SpacerHeight(MediumSpace)

        LazyVerticalGrid (
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize()
        ) {
            items(count = bookmarkState.books.size) { item ->
                BazarBookItem (
                    item = bookmarkState.books[item],
                    onClick = { navigateToDetails(bookmarkState.books[item]) }
                )
            }
        }
    }
}
