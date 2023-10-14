package com.camihruiz24.bookshelf.data.domain_model

data class Book(
    val id: String,
    val title: String,
    val description: String,
    val authors: List<String>,
    val imageUrl: String,
    val categories: List<String>,
)
