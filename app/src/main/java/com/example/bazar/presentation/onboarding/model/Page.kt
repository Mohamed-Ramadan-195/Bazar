package com.example.bazar.presentation.onboarding.model

import androidx.annotation.DrawableRes

data class Page (
    val title: String,
    val body: String,
    @DrawableRes val image: Int
)