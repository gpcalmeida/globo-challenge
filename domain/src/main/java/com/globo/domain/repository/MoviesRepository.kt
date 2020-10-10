package com.globo.domain.repository

import com.globo.domain.model.Movie
import io.reactivex.Single

interface MoviesRepository {

    fun getAllMovies() : Single<List<Movie>>
}