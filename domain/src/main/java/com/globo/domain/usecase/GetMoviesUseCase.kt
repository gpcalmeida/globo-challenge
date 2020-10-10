package com.globo.domain.usecase

import com.globo.domain.Result.MoviesResult
import com.globo.domain.repository.MovieRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor (
    private val moviesRepository: MovieRepository
) {
    fun execute() : Observable<MoviesResult> {
        return moviesRepository.getAllMovies()
            .toObservable()
            .map { MoviesResult.Success(it) as MoviesResult }
            .onErrorReturn { MoviesResult.Failure(it) }
            .startWith(MoviesResult.Loading)
    }
}
