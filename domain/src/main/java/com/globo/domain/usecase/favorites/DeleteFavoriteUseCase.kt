package com.globo.domain.usecase.favorites

import com.globo.domain.model.Movie
import com.globo.domain.repository.MovieRepository
import javax.inject.Inject

class DeleteFavoriteUseCase @Inject constructor(
    private val movieRepository: MovieRepository
){

    suspend fun execute(movie : Movie) {
        movieRepository.deleteFavorite(movie)
    }
}