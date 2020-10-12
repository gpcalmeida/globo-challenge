package com.globo.domain.usecase.session

import com.globo.domain.repository.UserRepository
import javax.inject.Inject

class ClearSessionUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    fun execute() {
        userRepository.logout()
    }
}