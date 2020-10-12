package com.globo.domain.usecase.favorites

import com.globo.domain.model.Movie
import com.globo.domain.repository.MovieRepository
import com.globo.domain.repository.UserRepository
import com.globo.domain.usecase.session.GetSavedUserUseCase
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val userRepository: UserRepository
) {

    suspend fun execute() : List<Movie> {
        val user = userRepository.getSavedUser() ?: ""
        return movieRepository.getFavorites(user)
    }
}