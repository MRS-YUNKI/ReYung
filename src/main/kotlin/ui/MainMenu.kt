package org.example.ui

class MainMenu(
    private val UserUI: UserUI) {
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

        }
    }

    fun displayMenu(){
        println(menuItems.joinToString("\n"))
        val menuPosition = readlnOrNull()?.toIntOrNull()

        if (menuPosition == null) displayMenu()
        when (menuPosition){
            1 -> {
                displayMenuItem {
                    UserUI.authorize()
                    displayMenuForAuthorizeUser()
                }
            }
            2 -> {
                displayMenuItem {
                    UserUI.registration()
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
    fun displayMenuForAuthorizeUser(){
        println(menuAuthorizedItems.joinToString ("\n"))
        val menuPosition = readlnOrNull()?.toIntOrNull()
        if (menuPosition == null) displayMenuForAuthorizeUser()
            when (menuPosition){
                1 -> {
                    displayMenuItem {
                        UserUI.changePassword()
                    }
                }
                2 -> {
                    displayMenuItem {
                        UserUI.changeProfile()
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
}
