package org.example.domain.Response

data class ShoesResponse(
    val shoesId: Int,
    val shoesName: String,
    val shoesDescription: String,
    val shoesUrl: String,
    val category: String,
)
{
    override fun toString(): String {
        return "Название: $shoesName\nОписание: $shoesDescription"
    }
}