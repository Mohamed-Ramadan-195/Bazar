package com.example.bazar.data.remote.dto.category

data class Subject(
    val key: String,
    val name: String,
    val subject_type: String,
    val work_count: Int,
    val works: List<Work>
)