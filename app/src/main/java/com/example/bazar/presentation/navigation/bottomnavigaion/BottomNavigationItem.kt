package com.example.bazar.presentation.navigation.bottomnavigaion

import androidx.annotation.DrawableRes

data class BottomNavigationItem (
    @DrawableRes val icon: Int,
    @DrawableRes val iconFocused: Int,
    val label: String
)
