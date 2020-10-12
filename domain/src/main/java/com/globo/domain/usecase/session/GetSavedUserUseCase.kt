package com.globo.domain.usecase.session

import com.globo.domain.model.User
import com.globo.domain.repository.UserRepository
import javax.inject.Inject

class GetSavedUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    fun execute() : String? {
        return userRepository.getSavedUser()
    }
}