package com.example.bazar.presentation.screen.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bazar.domain.model.Item
import com.example.bazar.presentation.common.BazarBookItem
import com.example.bazar.presentation.common.BazarSearchBar
import com.example.bazar.presentation.common.BazarSpacerHeight
import com.example.bazar.util.Dimen.MediumSpace
import com.example.bazar.util.Dimen.SmallSpace

@Composable
fun SearchScreen(
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
        BazarSpacerHeight(MediumSpace)
        BazarSearchBar (
            text = searchState.searchQuery,
            readOnly = false,
            onValueChange = { searchEvent(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = { searchEvent(SearchEvent.SearchBooks) }
        )
        BazarSpacerHeight(MediumSpace)
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

