package com.globo.challenge.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.globo.challenge.BaseApplication
import com.globo.challenge.ext.addTo
import com.globo.challenge.presentation.BaseViewModel
import com.globo.domain.Result
import com.globo.domain.model.Movie
import com.globo.domain.usecase.favorites.GetFavoritesUseCase
import com.globo.domain.usecase.movies.GetMoviesUseCase
import com.globo.domain.usecase.favorites.InsertFavoriteUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val insertFavoriteUseCase: InsertFavoriteUseCase,
    application: BaseApplication
) : BaseViewModel(application) {

    private val movies = MutableLiveData<List<Movie>>().apply { value = null }
    fun getMovies() : LiveData<List<Movie>> = movies

    private val favorites = MutableLiveData<List<Movie>>().apply { value = null }
    fun getFavorites() : LiveData<List<Movie>> = favorites

    fun bound() {
        getAllMovies()
    }

    fun getAllMovies() {
        getMoviesUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { handleMoviesResult(it) }
            .addTo(disposables)
    }

    private fun handleMoviesResult(result : Result.MoviesResult) {
        when(result) {
            is Result.MoviesResult.Success -> {
               GlobalScope.launch {
                   result.movies.forEach {
                       insertFavoriteUseCase.execute(it)

                   }
                   getFavorites()
               }
            }
            is Result.MoviesResult.Failure -> {}
            is Result.MoviesResult.Loading -> {}
        }
    }

    suspend fun getDbFavorites() {
        val abc = getFavoritesUseCase.execute()
        val def = abc
    }

}