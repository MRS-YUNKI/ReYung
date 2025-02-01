package org.example.domain.Request

data class ShoesAddRequest (
    val shoesName: String,
    val shoesDescription: String,
    val shoesUrl: String,
    val category: String,
)