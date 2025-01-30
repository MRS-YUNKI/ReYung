package org.example.domain.Request

data class ChangeProfileRequest(
    val userId: Int,
    val newFirstName: String,
    val newLastName: String?,
    val newPhone: String?,
    val newAddress: String?
)