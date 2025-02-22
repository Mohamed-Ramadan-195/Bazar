package com.example.bazar.presentation.screen.search.state

import com.example.bazar.domain.model.Item

data class SearchState (
    val searchQuery: String = "",
    val books: List<Item> = emptyList()
)
