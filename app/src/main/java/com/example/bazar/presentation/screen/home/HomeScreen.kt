package com.example.bazar.presentation.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bazar.domain.model.Item
import com.example.bazar.presentation.common.BazarBookItem
import com.example.bazar.presentation.common.SearchBarItem
import com.example.bazar.presentation.common.SpacerHeight
import com.example.bazar.ui.theme.PrimaryColor
import com.example.bazar.util.Dimen.SmallSpace
import com.example.bazar.util.Dimen.UnderMediumSpace

@Composable
fun HomeScreen (
    navigateToSearch: () -> Unit,
    navigateToCategory: () -> Unit,
    navigateToDetails: (Item) -> Unit
) {
    val homeViewModel: HomeViewModel = hiltViewModel()
    val state by homeViewModel.state

    HomeScreenContent (
        navigateToSearch = navigateToSearch,
        navigateToCategory = navigateToCategory,
        navigateToDetails = navigateToDetails,
        booksState = state
    )
}

@Composable
fun HomeScreenContent (
    navigateToSearch: () -> Unit,
    navigateToCategory: () -> Unit,
    navigateToDetails: (Item) -> Unit,
    booksState: BooksState
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding()
            .padding(vertical = SmallSpace, horizontal = UnderMediumSpace)
    ) {
        Text (
            text = "Home",
            fontSize = 24.sp,
            fontFamily = FontFamily.Serif,
            color = PrimaryColor
        )
        SpacerHeight(SmallSpace)

        SearchBarItem (
            text = "",
            readOnly = true,
            onValueChange = {},
            onSearch = {},
            onClick = { navigateToSearch() }
        )
        SpacerHeight(SmallSpace)

        // Programming
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text (
                modifier = Modifier.padding(start = SmallSpace),
                text = "Programming",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Serif,
                color = Color.Black
            )
            TextButton (
                onClick = navigateToCategory
            ) {
                Text (
                    text = "See All",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    color = PrimaryColor
                )
            }
        }

        // Programming Books
        LazyRow (
            contentPadding = PaddingValues(SmallSpace)
        ) {
            items(booksState.programmingBooks.size) { index ->
                val book = booksState.programmingBooks[index]
                BazarBookItem (
                    item = book,
                    onClick = { navigateToDetails(book) }
                )
            }
        }

        // Education
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text (
                modifier = Modifier.padding(start = SmallSpace),
                text = "Education",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Serif,
                color = Color.Black
            )
            TextButton (
                onClick = navigateToCategory
            ) {
                Text (
                    text = "See All",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    color = PrimaryColor
                )
            }
        }

        // Education Books
        LazyRow (
            contentPadding = PaddingValues(SmallSpace)
        ) {
            items(booksState.educationBooks.size) { index ->
                val book = booksState.educationBooks[index]
                BazarBookItem (
                    item = book,
                    onClick = { navigateToDetails(book) }
                )
            }
        }
    }
}