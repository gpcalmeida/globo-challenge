package com.globo.challenge.di.application


import android.content.Context
import api.MockApi
import com.globo.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import mapper.MovieMapper
import repository.MovieRepositoryImpl
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMoviesRepository(mockApi: MockApi, movieMapper: MovieMapper, context: Context): MovieRepository {
        return MovieRepositoryImpl(mockApi = mockApi, movieMapper = movieMapper, context = context)
    }

}