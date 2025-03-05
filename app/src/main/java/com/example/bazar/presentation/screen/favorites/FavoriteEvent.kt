package com.example.bazar.presentation.screen.favorites

import com.example.bazar.domain.model.Item

sealed class FavoriteEvent {
    data class OperationsInBook (
        val item: Item
    ): FavoriteEvent()

    data object RemoveSideEffect: FavoriteEvent()
}