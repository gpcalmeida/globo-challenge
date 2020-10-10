package com.globo.domain.repository

import com.globo.domain.model.Movie
import io.reactivex.Single

interface MovieRepository {

    fun getAllMovies() : Single<List<Movie>>

    suspend fun insertFavorite(movie : Movie)

    suspend fun getFavorites() : List<Movie>
}