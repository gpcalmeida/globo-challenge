package com.globo.domain.usecase.user

import com.globo.domain.model.User
import com.globo.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend fun execute(user : User) : User {
        return userRepository.getUser(user.user, user.password)
    }
}