package com.rendra.newscompose.model

data class News(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val author: String,
    val date: String,
    val description: String,
)
