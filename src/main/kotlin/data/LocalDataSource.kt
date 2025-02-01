package org.example.data
import org.example.data.model.ShoesDTO
import org.example.data.model.UserDTO

val shoesList = listOf(
    ShoesDTO(
        shoesId = 1,
        shoesName = "Nike",
        shoesDescription = "Beauty",
        shoesUrl = "url1",
        category = "cat1"
    ),
    ShoesDTO(
        shoesId = 2,
        shoesName = "Nike",
        shoesDescription = "Beauty",
        shoesUrl = "url2",
        category = "cat2"
    ),
    ShoesDTO(
        shoesId = 3,
        shoesName = "Same",
        shoesDescription = "Beauty",
        shoesUrl = "url3",
        category = "cat1"
    )
)

val userList = listOf(
    UserDTO(
        userId = 1,
        firstName = "Andrey",
        password = "123",
        email  = "test1@gmail.com"
        ),
    UserDTO(
        userId = 2,
        firstName = "Bogdan",
        password = "321",
        email  = "test2@gmail.com"
    ),
    UserDTO(
        userId = 3,
        firstName = "Vlad",
        password = "1122",
        email  = "test3@gmail.com")
)