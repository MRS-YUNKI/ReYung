package org.example.domain.Response

import org.example.data.model.UserDTO
import org.example.domain.Pesponse.UserResponse

fun UserDTOtoUserResponse(userDTO: UserDTO) = UserResponse(
    lastName = userDTO.lastName,
    firstName = userDTO.firstName,
    email = userDTO.email,
    phone = userDTO.phone,
    userId = userDTO.userId,
    address = userDTO.address
)