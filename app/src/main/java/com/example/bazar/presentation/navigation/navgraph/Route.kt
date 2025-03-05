package com.example.bazar.presentation.navigation.navgraph

import com.example.bazar.util.Constant.APP_START_NAVIGATION
import com.example.bazar.util.Constant.BAZAR_NAVIGATION
import com.example.bazar.util.Constant.BAZAR_NAVIGATOR
import com.example.bazar.util.Constant.SEARCH_SCREEN
import com.example.bazar.util.Constant.CATEGORY_SCREEN
import com.example.bazar.util.Constant.DETAILS_SCREEN
import com.example.bazar.util.Constant.HOME_SCREEN
import com.example.bazar.util.Constant.ON_BOARDING_SCREEN
import com.example.bazar.util.Constant.FAVORITE_SCREEN

sealed class Route (
    val route: String
) {
    // Navigation
    data object AppStartNavigation: Route(route = APP_START_NAVIGATION)
    data object BazarNavigation: Route(route = BAZAR_NAVIGATION)
    data object BazarNavigator: Route(route = BAZAR_NAVIGATOR)

    // Screen
    data object OnBoardingScreen: Route(route = ON_BOARDING_SCREEN)
    data object HomeScreen: Route(route = HOME_SCREEN)
    data object CategoryScreen: Route(route = CATEGORY_SCREEN)
    data object SearchScreen: Route(route = SEARCH_SCREEN)
    data object FavoriteScreen: Route(route = FAVORITE_SCREEN)
    data object DetailsScreen: Route(route = DETAILS_SCREEN)
}