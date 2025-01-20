package com.example.bazar.presentation.navigation.bottomnavigaion

import androidx.annotation.DrawableRes

data class BottomNavigationItem (
    @DrawableRes
    val icon: Int,
    val address: String
)
