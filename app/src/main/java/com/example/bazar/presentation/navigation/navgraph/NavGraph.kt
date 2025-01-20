package com.example.bazar.presentation.navigation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.bazar.presentation.onboarding.screen.OnBoardingScreen
import com.example.bazar.presentation.onboarding.viewmodel.OnBoardingViewModel

@Composable
fun NavGraph (
    startDestination: String
) {
    val navController = rememberNavController()
    NavHost (
        navController = navController,
        startDestination = startDestination
    ) {
        navigation (
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable (
                route = Route.OnBoardingScreen.route
            ) {
                val onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(onBoardingViewModel::onEvent)
            }
        }

        navigation (
            route = Route.BazarNavigation.route,
            startDestination = Route.BazarNavigator.route
        ) {
            composable (
                route = Route.BazarNavigator.route
            ) {
                BazarNavigation()
            }
        }
    }
}