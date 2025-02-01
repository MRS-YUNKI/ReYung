package org.example.ui

import domain.Response.UserResponse
import org.example.domain.Request.AuthorizeRequest
import org.example.domain.Request.ChangePasswordRequest
import org.example.domain.Request.ChangeProfileRequest
import org.example.domain.Request.RegistrationRequest
import org.example.domain.UserUseCase

class UserUI(private val userUseCase: UserUseCase) {
    var userAuthorized: UserResponse? = null
    fun authorize(){
        println("Введите почту:")
        val email = readlnOrNull()
        checkNotNull(email) {
            "Почта не должна отсутствовать"
        }
        println("Введите пароль:")
        val password = readlnOrNull()
        checkNotNull(password) {
            "Пароль не должен отсутствовать"
        }
        val authorizeRequest = AuthorizeRequest(
            email = email,
            password = password)
        val user = userUseCase.authorize(authorizeRequest)
        userAuthorized = user
        println(printUserResponse(user))
    }

    fun changePassword(){
        checkNotNull(userAuthorized){
            "Вы не авторизованы"
        }
        println("Введите пароль")
        val password = readlnOrNull()
        checkNotNull(password){
            "Пароль не должен отсутствовать"
        }
        val changePasswordRequest = ChangePasswordRequest(
            userId = userAuthorized!!.userId,
            newPassword = password
        )
        userUseCase.changePassword(changePasswordRequest)
    }

    fun changeProfile(){
        checkNotNull(userAuthorized){
            "Вы не авторизованы"
        }
        println("Введите новое имя")
        val firstName = readlnOrNull()?.takeIf { it.isNotBlank() } ?: return println("Имя не должно отсутствовать")
        println("Введите новую фамилию")
        val lastName = readlnOrNull()
        println("Введите новый номер телефона")
        val phone = readlnOrNull()
        println("Введите новый адрес")
        val address = readlnOrNull()
        val changeProfileRequest = ChangeProfileRequest(
            userId = userAuthorized!!.userId,
            newFirstName = firstName,
            newLastName = lastName ?: userAuthorized!!.lastName,
            newPhone = phone ?: userAuthorized!!.phone,
            newAddress = address ?: userAuthorized!!.address,
        )
        userUseCase.changeProfile(changeProfileRequest)
    }

    fun registration(){
        println("Введите имя")
        val firstName = readlnOrNull()
        checkNotNull(firstName){
            "Имя не должно отсутствовать"
        }
        println("Введите почту")
        val email = readlnOrNull()
        checkNotNull(email){
            "Почта не должна отсутствовать"
        }
        println("Введите пароль")
        val password = readlnOrNull()
        checkNotNull(password){
            "Пароль не должен отсутствовать"
        }
        val registrationRequest = RegistrationRequest(
            email = email,
            firstName = firstName,
            password = password)
            val newUser = userUseCase.registration(registrationRequest)
        println(printUserResponse(newUser))
    }

    fun printUserResponse(userResponse: UserResponse) : String {
        val printOutput = StringBuilder()
        printOutput.append("Ваша почта ${userResponse.email}")
        printOutput.appendLine()
        printOutput.append("Ваше имя ${userResponse.firstName}")
        if (!userResponse.lastName.isNullOrBlank()) {
            printOutput.appendLine()
            printOutput.append("Ваша фамилия ${userResponse.lastName}")
        }
        if (!userResponse.phone.isNullOrBlank()) {
            printOutput.appendLine()
            printOutput.append("Ваш телефон ${userResponse.phone}")
        }
        if (!userResponse.address.isNullOrBlank()) {
            printOutput.appendLine()
            printOutput.append("Ваш адрес ${userResponse.address}")
        }
        return printOutput.toString()
    }
}