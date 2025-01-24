package com.example.bazar.presentation.screen.my_book

import com.example.bazar.domain.model.Item

data class MyBookState (
    val books: List<Item> = emptyList()
)
