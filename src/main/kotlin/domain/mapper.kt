package org.example.domain

import org.example.data.model.UserDTO
import domain.Response.UserResponse

fun UserDTOtoUserResponse(userDTO: UserDTO) = UserResponse(
    lastName = userDTO.lastName,
    firstName = userDTO.firstName,
    email = userDTO.email,
    phone = userDTO.phone,
    userId = userDTO.userId,
    address = userDTO.address
)