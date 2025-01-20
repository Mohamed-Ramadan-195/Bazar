package com.example.bazar.presentation.navigation.navgraph

import com.example.bazar.util.Constant.APP_START_NAVIGATION
import com.example.bazar.util.Constant.AUTHENTICATION_NAVIGATION
import com.example.bazar.util.Constant.AUTHENTICATION_NAVIGATOR
import com.example.bazar.util.Constant.BAZAR_NAVIGATION
import com.example.bazar.util.Constant.BAZAR_NAVIGATOR
import com.example.bazar.util.Constant.SEARCH_SCREEN
import com.example.bazar.util.Constant.CATEGORY_SCREEN
import com.example.bazar.util.Constant.HOME_SCREEN
import com.example.bazar.util.Constant.ON_BOARDING_SCREEN
import com.example.bazar.util.Constant.MY_BOOK_SCREEN
import com.example.bazar.util.Constant.SIGN_IN_SCREEN
import com.example.bazar.util.Constant.SIGN_UP_SCREEN

sealed class Route (
    val route: String
) {
    data object AppStartNavigation: Route(route = APP_START_NAVIGATION)
    data object AuthenticationNavigation: Route(route = AUTHENTICATION_NAVIGATION)
    data object AuthenticationNavigator: Route(route = AUTHENTICATION_NAVIGATOR)
    data object BazarNavigation: Route(route = BAZAR_NAVIGATION)
    data object BazarNavigator: Route(route = BAZAR_NAVIGATOR)

    data object OnBoardingScreen: Route(route = ON_BOARDING_SCREEN)
    data object SignInScreen: Route(route = SIGN_IN_SCREEN)
    data object SignUpScreen: Route(route = SIGN_UP_SCREEN)
    data object HomeScreen: Route(route = HOME_SCREEN)
    data object CategoryScreen: Route(route = CATEGORY_SCREEN)
    data object SearchScreen: Route(route = SEARCH_SCREEN)
    data object MyBookScreen: Route(route = MY_BOOK_SCREEN)
}