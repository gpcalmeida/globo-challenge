package com.globo.domain.usecase.user

import com.globo.domain.repository.UserRepository
import javax.inject.Inject

class ChangePasswordUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend fun execute(newPassword : String) {
        val user = userRepository.getSavedUser() ?: ""
        return userRepository.updatePassword(user, newPassword)
    }
}