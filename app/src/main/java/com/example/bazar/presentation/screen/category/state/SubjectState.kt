package com.example.bazar.presentation.screen.category.state

import com.example.bazar.data.remote.dto.category.Work

data class SubjectState (
     val subjects: MutableList<Work> = mutableListOf()
)
