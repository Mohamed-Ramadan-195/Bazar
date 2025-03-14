package com.example.bazar.presentation.screen.search.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bazar.R
import com.example.bazar.domain.model.Item
import com.example.bazar.presentation.common.BazarBookItem
import com.example.bazar.presentation.common.BazarSearchBar
import com.example.bazar.presentation.common.EmptyScreen
import com.example.bazar.presentation.common.SpacerHeight
import com.example.bazar.presentation.screen.search.state.SearchEvent
import com.example.bazar.presentation.screen.search.state.SearchState
import com.example.bazar.presentation.screen.search.viewmodel.SearchViewModel
import com.example.bazar.util.Dimen.MediumSpace
import com.example.bazar.util.Dimen.SmallSpace

@Composable
fun SearchScreen (
    navigateToDetails: (Item) -> Unit
) {
    val searchViewModel: SearchViewModel = hiltViewModel()
    val searchState = searchViewModel.searchState.value

    SearchScreenContent (
        searchState = searchState,
        searchEvent = searchViewModel::onEvent,
        navigateToDetails = navigateToDetails
    )
}

@Composable
fun SearchScreenContent (
    searchState: SearchState,
    searchEvent: (SearchEvent) -> Unit,
    navigateToDetails: (Item) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(all = MediumSpace)
            .statusBarsPadding()
    ) {
        SpacerHeight(MediumSpace)
        BazarSearchBar (
            text = searchState.searchQuery,
            readOnly = false,
            onValueChange = { searchEvent(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = { searchEvent(SearchEvent.SearchBooks) }
        )

        if (searchState.books.isEmpty()) {
            EmptyScreen (
                raw = R.raw.search,
                title = "No books found",
                subtitle = "Try searching for a different book"
            )
        }

        SpacerHeight(MediumSpace)
        LazyVerticalGrid (
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize().padding(SmallSpace)
        ) {
            items(count = searchState.books.size) { item ->
                BazarBookItem (
                    item = searchState.books[item],
                    onClick = { navigateToDetails(searchState.books[item]) }
                )
            }
        }
    }
}

