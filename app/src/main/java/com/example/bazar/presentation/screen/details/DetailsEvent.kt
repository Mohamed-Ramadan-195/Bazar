package com.example.bazar.presentation.screen.details

import com.example.bazar.domain.model.Item

sealed class DetailsEvent {
    data class OperationsBook(val item: Item): DetailsEvent()

    data object RemoveSideEffect: DetailsEvent()
}