package com.example.bazar.presentation.navigation.navgraph

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
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
import com.example.bazar.presentation.screen.category.view.CategoryScreen
import com.example.bazar.presentation.screen.details.view.DetailsEvent
import com.example.bazar.presentation.screen.details.view.DetailsScreen
import com.example.bazar.presentation.screen.details.viewmodel.DetailsViewModel
import com.example.bazar.presentation.screen.home.HomeScreen
import com.example.bazar.presentation.screen.search.view.SearchScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BazarNavigation () {
    val bottomNavigationItemData = remember {
        listOf (
            BottomNavigationItem (
                icon = R.drawable.icon_home,
                iconFocused = R.drawable.icon_home_focused,
                label = "Home"
            ),
            BottomNavigationItem (
                icon = R.drawable.icon_category,
                iconFocused = R.drawable.icon_category_focused,
                label = "Category"
            ),
            BottomNavigationItem (
                icon = R.drawable.icon_search,
                iconFocused = R.drawable.icon_search,
                label = "Search"
            ),
            BottomNavigationItem (
                icon = R.drawable.icon_bookmark,
                iconFocused = R.drawable.icon_bookmark_focused,
                label = "Bookmark"
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
        NavHost (
            navController = navController,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier.padding()
        ) {
            composable (route = Route.HomeScreen.route) {
                HomeScreen(
                    navigateToSearch = { navigateToTap(navController, Route.SearchScreen.route) },
                    navigateToCategory = { navigateToTap(navController, Route.CategoryScreen.route) },
                    navigateToDetails = { item -> navigateToDetails(navController, item) }
                )
            }
            composable (route = Route.CategoryScreen.route) {
                CategoryScreen (
                    navigateToDetails = { item -> navigateToDetails(navController, item) }
                )
            }
            composable (route = Route.SearchScreen.route) {
                SearchScreen (
                    navigateToDetails = { item -> navigateToDetails(navController, item) }
                )
            }
            composable (route = Route.MyBookScreen.route) {
                MyBookScreen (
                    navigateToDetails = { item -> navigateToDetails(navController, item) }
                )
            }
            composable(route = Route.DetailsScreen.route) {
                val detailsViewModel: DetailsViewModel = hiltViewModel()
                if (detailsViewModel.sideEffect != null) {
                    Toast.makeText(LocalContext.current, detailsViewModel.sideEffect, Toast.LENGTH_SHORT).show()
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