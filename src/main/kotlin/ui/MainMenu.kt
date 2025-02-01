package org.example.ui

class MainMenu(
    private val userUI: UserUI) {
    val menuItems = listOf(
        "1. Авторизоваться",
        "2. Зарегестрироваться",
        "3. Выход"
    )
    val menuAuthorizedItems = listOf(
        "1. Сменить пароль",
        "2. Сменить профиль",
        "3. Выход"
    )

    private fun displayMenuItem(menuItem: () -> Unit){
        try {
            menuItem()
        }
        catch (e: Exception){
            println(e.message)
            userUI.userAuthorized?.let {
                displayMenuForAuthorizeUser()
            }
        }
    }

    fun displayMenu(){
        println(menuItems.joinToString("\n"))
        val menuPosition = readlnOrNull()?.toIntOrNull()

        if (menuPosition == null) displayMenu()
        when (menuPosition){
            1 -> {
                displayMenuItem {
                    userUI.authorize()
                    displayMenuForAuthorizeUser()
                }
            }
            2 -> {
                displayMenuItem {
                    userUI.registration()
                    displayMenu()
                }
            }
            3 -> {
                return
            }
            else -> {
                displayMenu()
            }
        }
    }

    private fun displayMenuForAuthorizeUser(){
        println(menuAuthorizedItems.joinToString ("\n"))
        val menuPosition = readlnOrNull()?.toIntOrNull()
        if (menuPosition == null) displayMenuForAuthorizeUser()
            when (menuPosition){
                1 -> {
                    displayMenuItem {
                        userUI.changePassword()
                    }
                }
                2 -> {
                    userUI.changeProfile()
                }
                3 -> {
                    return
                }
                else -> displayMenuForAuthorizeUser()
            }
    }
}
