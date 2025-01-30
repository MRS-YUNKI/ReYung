package org.example.data

import org.example.data.model.UserDTO
import org.example.domain.Request.RegistrationRequest

interface UserRepository {

    fun addUser(registrationRequest: RegistrationRequest) : UserDTO
    fun removeUserById(userId: Int) : Boolean
    fun updateUserById(userId: Int, newUser: UserDTO) : UserDTO
    fun getAllUsers() : List<UserDTO>
    fun findUserbyId(userId: Int) : UserDTO
}