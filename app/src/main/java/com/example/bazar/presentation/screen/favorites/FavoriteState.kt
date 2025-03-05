package com.example.bazar.presentation.screen.favorites

import com.example.bazar.domain.model.Item

data class FavoriteState (
    val books: List<Item> = emptyList()
)
