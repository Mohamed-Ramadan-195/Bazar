package com.example.bazar.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bazar.R
import com.example.bazar.domain.model.Item
import com.example.bazar.presentation.common.BookCardContent
import com.example.bazar.util.Dimen.ExtraSmallSpace
import com.example.bazar.util.Dimen.SmallSpace
import com.example.bazar.util.Dimen.UnderMediumSpace

@Composable
fun HomeScreen (
    navigateToSearch: () -> Unit,
    navigateToDetails: (Item) -> Unit
) {
    val homeViewModel: HomeViewModel = hiltViewModel()
    val state by homeViewModel.state

    HomeScreenContent (
        navigateToSearch = navigateToSearch,
        navigateToDetails = navigateToDetails,
        booksState = state
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent (
    navigateToSearch: () -> Unit,
    navigateToDetails: (Item) -> Unit,
    booksState: BooksState
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding()
            .padding(vertical = SmallSpace, horizontal = UnderMediumSpace)
    ) {
        TopAppBar (
            modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
            colors = TopAppBarDefaults.topAppBarColors (
                containerColor = Color.Transparent,
                navigationIconContentColor = Black,
                actionIconContentColor = Black
            ),
            title = {
                Text (
                    text = "Home",
                    fontSize = 24.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    color = Black,
                    textAlign = TextAlign.Center
                )
            },
            navigationIcon = {
                IconButton (
                    onClick = { navigateToSearch() }
                ) {
                    Icon (
                        painter = painterResource(id = R.drawable.icon_search),
                        contentDescription = "Search"
                    )
                }
            },
            actions = {
                Icon (
                    imageVector = Icons.Outlined.Info,
                    contentDescription = null,
                )
            }
        )

        val programmingPagerState = rememberPagerState(initialPage = 0) { booksState.programmingBooks.size }
        HorizontalPager (
            state = programmingPagerState,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(vertical = ExtraSmallSpace)
        ) { page ->
            BookCardContent (
                index = page,
                pagerState = programmingPagerState,
                item = booksState.programmingBooks[page],
                onClick = navigateToDetails
            )
        }
    }
}