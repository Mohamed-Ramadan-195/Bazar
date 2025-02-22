package com.example.bazar.presentation.screen.search.state

sealed class SearchEvent {
    data class UpdateSearchQuery (
        val searchQuery: String
    ) : SearchEvent()

    data object SearchBooks: SearchEvent()
}