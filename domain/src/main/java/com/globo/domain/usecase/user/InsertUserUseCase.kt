package com.globo.domain.usecase.user

import com.globo.domain.model.User
import com.globo.domain.repository.UserRepository
import javax.inject.Inject

class InsertUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend fun execute(user : User) {
        userRepository.registerUser(user)
    }
}