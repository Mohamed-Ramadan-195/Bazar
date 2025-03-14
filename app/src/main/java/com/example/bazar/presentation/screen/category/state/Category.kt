package com.example.bazar.presentation.screen.category.state

import androidx.compose.ui.graphics.Color
import com.example.bazar.ui.theme.PrimaryColor

data class Category (
    val category: String,
    val isSelected: Boolean = false,
    val textColor: Color = if (isSelected) Color.White else Color.Gray,
    val boxColor: Color = if (isSelected) PrimaryColor else Color.Transparent
)
