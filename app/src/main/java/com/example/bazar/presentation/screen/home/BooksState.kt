package com.example.bazar.presentation.screen.home

import com.example.bazar.domain.model.Item

data class BooksState (
    val programmingBooks: List<Item> = emptyList(),
    val educationBooks: List<Item> = emptyList()
)