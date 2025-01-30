package org.example.data
import org.example.data.model.ShoesDTO
import org.example.data.model.UserDTO

val shoesList = listOf(
    ShoesDTO(
        shoesId = 1,
        shoesName = "Nike",
        shoesDesc = "Beauty",
        shoesUrl = "url1",
        category = "cat1"
    ),
    ShoesDTO(
        shoesId = 2,
        shoesName = "Nike",
        shoesDesc = "Beauty",
        shoesUrl = "url2",
        category = "cat1"
    ),
    ShoesDTO(
        shoesId = 3,
        shoesName = "Same",
        shoesDesc = "Beauty",
        shoesUrl = "url3",
        category = "cat2"
    )
)

val userList = listOf(
    UserDTO(
        userId = 1,
        firstName = "Andrey",
        password = "123",
        email  = "testemail1@gmail.com"
        ),
    UserDTO(
        userId = 2,
        firstName = "Bogdan",
        password = "321",
        email  = "testemail2@gmail.com"
    ),
    UserDTO(
        userId = 3,
        firstName = "Vlad",
        password = "33221",
        email  = "testemail3@gmail.com")
)