package com.example.bazar.presentation.screen.bookmark

import com.example.bazar.domain.model.Item

data class BookmarkState (
    val books: List<Item> = emptyList()
)
