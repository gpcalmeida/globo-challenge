package com.globo.domain.usecase

import com.globo.domain.model.Movie
import com.globo.domain.repository.MovieRepository
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend fun execute() : List<Movie> {
        return movieRepository.getFavorites()
    }
}