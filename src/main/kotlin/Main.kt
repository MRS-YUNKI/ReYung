package org.example

import org.example.data.FavouriteRepositoryImpl
import org.example.data.ShoesRepositoryImpl
import org.example.data.UserRepositoryImpl
import org.example.domain.ShoesUseCase
import org.example.domain.UserUseCaseImpl
import org.example.ui.MainMenu
import org.example.ui.UserUI

fun main() {
    val userRepository = UserRepositoryImpl()
    val favouriteRepository = FavouriteRepositoryImpl()
    val shoesRepository = ShoesRepositoryImpl()
    val userUseCase = UserUseCaseImpl(userRepository, favouriteRepository, shoesRepository)
    val userUI = UserUI(userUseCase)
    val mainMenu = MainMenu(userUI)
    mainMenu.displayMenu()
}