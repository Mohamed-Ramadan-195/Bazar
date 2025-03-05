package com.example.bazar.presentation.navigation.navgraph

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bazar.R
import com.example.bazar.domain.model.Item
import com.example.bazar.presentation.navigation.bottomnavigaion.BazarBottomNavigation
import com.example.bazar.presentation.navigation.bottomnavigaion.BottomNavigationItem
import com.example.bazar.presentation.screen.favorites.FavoriteScreen
import com.example.bazar.presentation.screen.category.view.CategoryScreen
import com.example.bazar.presentation.screen.details.DetailsScreen
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
                icon = R.drawable.ic_favorite,
                iconFocused = R.drawable.ic_favorite_focused,
                label = "Favorite"
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
            Route.FavoriteScreen.route -> 3
            else -> 0
        }
    }

    val isBottomBarVisible = remember(key1 = navBackStackEntry) {
        navBackStackEntry?.destination?.route == Route.HomeScreen.route ||
        navBackStackEntry?.destination?.route == Route.CategoryScreen.route ||
        navBackStackEntry?.destination?.route == Route.SearchScreen.route ||
        navBackStackEntry?.destination?.route == Route.FavoriteScreen.route
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
                                route = Route.FavoriteScreen.route
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
            composable (route = Route.FavoriteScreen.route) {
                FavoriteScreen (
                    navigateToDetails = { item -> navigateToDetails(navController, item) }
                )
            }
            composable(route = Route.DetailsScreen.route) {
                navController.previousBackStackEntry?.savedStateHandle?.get<Item?>("item")
                    ?.let { item ->
                        DetailsScreen (
                            item = item,
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
    item: Item?
) {
    navController.currentBackStackEntry?.savedStateHandle?.set("item", item)
    navController.navigate(route = Route.DetailsScreen.route)
}