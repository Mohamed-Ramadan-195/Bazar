package com.example.bazar.presentation.screen.favorites

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
fun FavoriteScreen (
    navigateToDetails: (Item) -> Unit
) {
    val favoriteViewModel: FavoriteViewModel = hiltViewModel()
    val state = favoriteViewModel.state.value

    FavoriteScreenContent (
        favoriteState = state,
        navigateToDetails = navigateToDetails
    )
}

@Composable
fun FavoriteScreenContent (
    favoriteState: FavoriteState,
    navigateToDetails: (Item) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(MediumSpace)
            .statusBarsPadding()
    ) {
        // No Favorites books
        if (favoriteState.books.isEmpty()) {
            EmptyScreen (
                raw = R.raw.favorite,
                title = "No Favorites books",
                subtitle = "You haven't favorite any books yet"
            )
        }

        // Display favorites books
        SpacerHeight(MediumSpace)
        BazarTextHeadline("Favorites")
        SpacerHeight(MediumSpace)

        LazyVerticalGrid (
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize()
        ) {
            items(count = favoriteState.books.size) { item ->
                BazarBookItem (
                    item = favoriteState.books[item],
                    onClick = { navigateToDetails(favoriteState.books[item]) }
                )
            }
        }
    }
}
