package com.example.bazar.presentation.navigation.navgraph

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bazar.R
import com.example.bazar.domain.model.Item
import com.example.bazar.presentation.navigation.bottomnavigaion.BazarBottomNavigation
import com.example.bazar.presentation.navigation.bottomnavigaion.BottomNavigationItem
import com.example.bazar.presentation.screen.my_book.MyBookScreen
import com.example.bazar.presentation.screen.category.CategoryScreen
import com.example.bazar.presentation.screen.category.CategoryViewModel
import com.example.bazar.presentation.screen.details.DetailsEvent
import com.example.bazar.presentation.screen.details.DetailsScreen
import com.example.bazar.presentation.screen.details.DetailsViewModel
import com.example.bazar.presentation.screen.home.HomeScreen
import com.example.bazar.presentation.screen.my_book.MyBookViewModel
import com.example.bazar.presentation.screen.search.SearchScreen
import com.example.bazar.presentation.screen.search.SearchViewModel

@Composable
fun BazarNavigation () {
    val bottomNavigationItemData = remember {
        listOf (
            BottomNavigationItem (
                icon = R.drawable.ic_home,
                address = "Home"
            ),
            BottomNavigationItem (
                icon = R.drawable.ic_category,
                address = "Category"
            ),
            BottomNavigationItem (
                icon = R.drawable.ic_search,
                address = "Search"
            ),
            BottomNavigationItem (
                icon = R.drawable.favourite_book,
                address = "My Book"
            )
        )
    }

    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    var selectedItem by remember { mutableIntStateOf(0) }

    selectedItem = remember(key1 = navBackStackEntry) {
        when (navBackStackEntry?.destination?.route) {
            Route.HomeScreen.route -> 0
            Route.CategoryScreen.route -> 1
            Route.SearchScreen.route -> 2
            Route.MyBookScreen.route -> 3
            else -> 0
        }
    }

    val isBottomBarVisible = remember(key1 = navBackStackEntry) {
        navBackStackEntry?.destination?.route == Route.HomeScreen.route ||
        navBackStackEntry?.destination?.route == Route.CategoryScreen.route ||
        navBackStackEntry?.destination?.route == Route.SearchScreen.route ||
        navBackStackEntry?.destination?.route == Route.MyBookScreen.route
    }

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (isBottomBarVisible) {
                BazarBottomNavigation (
                    items = bottomNavigationItemData,
                    onItemSelected = selectedItem,
                    onItemClick = { index ->
                        when (index) {
                            0 -> navigateToTap (
                                navController = navController,
                                route = Route.HomeScreen.route
                            )

                            1 -> navigateToTap (
                                navController = navController,
                                route = Route.CategoryScreen.route
                            )

                            2 -> navigateToTap (
                                navController = navController,
                                route = Route.SearchScreen.route
                            )

                            3 -> navigateToTap (
                                navController = navController,
                                route = Route.MyBookScreen.route
                            )
                        }
                    }
                )
            }
        }
    ) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost (
            navController = navController,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            composable (route = Route.HomeScreen.route) {
                HomeScreen()
            }
            composable (route = Route.CategoryScreen.route) {
                val categoryViewModel: CategoryViewModel = hiltViewModel()
                val categoryState by categoryViewModel.categoryState.collectAsState()
                val subjectState by categoryViewModel.subjectState
                CategoryScreen (
                    categoryState = categoryState,
                    onClickCategory = { category -> categoryViewModel.onCategoryClick(category) },
                    books = subjectState.subjects,
                    navigateToDetails = { item -> navigateToDetails(navController, item) }
                )
            }
            composable (route = Route.SearchScreen.route) {
                val searchViewModel: SearchViewModel = hiltViewModel()
                val searchState = searchViewModel.searchState.value
                SearchScreen (
                    searchState = searchState,
                    searchEvent = searchViewModel::onEvent,
                    navigateToDetails = { item -> navigateToDetails(navController, item) }
                )
            }
            composable (route = Route.MyBookScreen.route) {
                val myBookViewModel: MyBookViewModel = hiltViewModel()
                val state = myBookViewModel.state.value
                MyBookScreen (
                    myBookState = state,
                    navigateToDetails = { item -> navigateToDetails(navController, item) }
                )
            }
            composable(route = Route.DetailsScreen.route) {
                val detailsViewModel: DetailsViewModel = hiltViewModel()
                if (detailsViewModel.sideEffect != null) {
                    Toast.makeText(
                        LocalContext.current,
                        detailsViewModel.sideEffect,
                        Toast.LENGTH_SHORT
                    ).show()
                    detailsViewModel.onEvent(DetailsEvent.RemoveSideEffect)
                }
                navController.previousBackStackEntry?.savedStateHandle?.get<Item?>("item")
                    ?.let { item ->
                        DetailsScreen (
                            item = item,
                            detailsEvent = detailsViewModel::onEvent,
                            navigateUp = { navController.navigateUp() }
                        )
                    }
            }
        }
    }
}

fun navigateToTap (
    navController: NavController,
    route: String
) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { homeScreen ->
            popUpTo(homeScreen) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }
}

private fun navigateToDetails (
    navController: NavController,
    item: Item
) {
    navController.currentBackStackEntry?.savedStateHandle?.set("item", item)
    navController.navigate(route = Route.DetailsScreen.route)
}