package com.globo.domain

import com.globo.domain.model.Movie

abstract class Result {

    sealed class MoviesResult {
        object Loading : MoviesResult()
        data class Success(val movies: List<Movie>) : MoviesResult()
        data class Failure(val throwable: Throwable) : MoviesResult()
    }
}