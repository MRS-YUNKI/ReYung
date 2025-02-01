package org.example.domain

import org.example.data.UserRepository
import domain.Response.UserResponse
import org.example.domain.Request.AuthorizeRequest
import org.example.domain.Request.ChangePasswordRequest
import org.example.domain.Request.ChangeProfileRequest
import org.example.domain.Request.RegistrationRequest

class UserUseCaseImpl (private val userRepository: UserRepository) : UserUseCase {
    override fun authorize(authorizeRequest: AuthorizeRequest): UserResponse {
        val findUser = userRepository.getAllUsers()
            .firstOrNull {
                it.email == authorizeRequest.email
            }
        checkNotNull(findUser){
            "Пользователь с такой почтой не найден"
        }
        require(findUser.password == authorizeRequest.password) {
            "Пароли не совпадают"
        }
        return UserDTOtoUserResponse(findUser)
    }

    override fun registration(registrationRequest: RegistrationRequest): UserResponse {
        val isUnique = userRepository.getAllUsers().firstOrNull {
            it.email == registrationRequest.email
        } == null
        require(isUnique) {
            "Такая почта уже существует"
        }
        val newUser = userRepository.addUser(registrationRequest)
        return UserDTOtoUserResponse(newUser)
    }

    override fun changePassword(changePasswordRequest: ChangePasswordRequest) {
        var updatedUser = userRepository.findUserbyId(changePasswordRequest.userId)
        updatedUser.password = changePasswordRequest.newPassword
        userRepository.updateUserById(changePasswordRequest.userId, updatedUser)
    }

    override fun changeProfile(changeProfileRequest: ChangeProfileRequest) {
        var updatedUser = userRepository.findUserbyId(changeProfileRequest.userId)
        if (!changeProfileRequest.newFirstName.isNullOrEmpty()) updatedUser.firstName = changeProfileRequest.newFirstName
        if (!changeProfileRequest.newLastName.isNullOrEmpty()) updatedUser.lastName = changeProfileRequest.newLastName
        if (!changeProfileRequest.newPhone.isNullOrEmpty()) updatedUser.phone = changeProfileRequest.newPhone
        if (!changeProfileRequest.newAddress.isNullOrEmpty()) updatedUser.address = changeProfileRequest.newAddress
        userRepository.updateUserById(changeProfileRequest.userId, updatedUser)
    }
}