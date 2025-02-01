package org.example

import org.example.data.UserRepositoryImpl
import org.example.domain.UserUseCaseImpl
import org.example.ui.MainMenu
import org.example.ui.UserUI

fun main() {
    val userRepository = UserRepositoryImpl()
    val userUseCase = UserUseCaseImpl(userRepository)
    val userUI = UserUI(userUseCase)
    val mainMenu = MainMenu(userUI)
}