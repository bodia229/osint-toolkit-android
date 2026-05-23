package com.osint.toolkit.model

data class Tool(
    val id: Int,
    val name: String,
    val url: String,
    val description: String,
    val categoryId: Int
)
