package com.globo.domain.usecase.favorites

import com.globo.domain.model.Movie
import com.globo.domain.repository.MovieRepository
import com.globo.domain.repository.UserRepository
import javax.inject.Inject

class InsertFavoriteUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val userRepository: UserRepository
) {

    suspend fun execute(movie : Movie) {
        movie.let {
            it.user = userRepository.getSavedUser() ?: ""
            it.isFavorite = true
        }
        movieRepository.insertFavorite(movie)
    }
}