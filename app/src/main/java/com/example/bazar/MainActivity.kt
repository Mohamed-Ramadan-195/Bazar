package com.example.bazar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.example.bazar.presentation.navigation.navgraph.NavGraph
import com.example.bazar.ui.theme.BazarTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                mainViewModel.splashCondition
            }
        }

        setContent {
            BazarTheme {
                NavGraphContent(mainViewModel)
            }
        }
    }
}

@Composable
private fun NavGraphContent(mainViewModel: MainViewModel) {
    val isSystemInDarkTheme = isSystemInDarkTheme()
    @Suppress("DEPRECATION")
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor (
            color = Color.Transparent,
            darkIcons = !isSystemInDarkTheme
        )
    }
    Box (
        modifier = Modifier.background (color = MaterialTheme.colorScheme.background)
    ) {
        val startDestination = mainViewModel.startDestination
        NavGraph(startDestination)
    }
}