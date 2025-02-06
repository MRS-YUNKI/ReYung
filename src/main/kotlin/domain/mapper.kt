package org.example.domain

import org.example.data.model.UserDTO
import domain.Response.UserResponse
import org.example.data.model.ShoesDTO
import org.example.data.shoesList
import org.example.domain.Response.ShoesResponse

fun UserDTOtoUserResponse(userDTO: UserDTO, shoesList: List<ShoesDTO> = emptyList()) = UserResponse(
    lastName = userDTO.lastName,
    firstName = userDTO.firstName,
    email = userDTO.email,
    phone = userDTO.phone,
    userId = userDTO.userId,
    address = userDTO.address,
    favouriteList = shoesList.map { ::ShoesDTOtoUserResponse }
)


fun ShoesDTOtoUserResponse(shoesDTO: ShoesDTO) : ShoesResponse{
    return ShoesResponse(
        shoesId = shoesDTO.shoesId,
        shoesName = shoesDTO.shoesName,
        shoesUrl = shoesDTO.shoesUrl,
        shoesDescription = shoesDTO.shoesDescription,
        category = shoesDTO.category,
    )
}