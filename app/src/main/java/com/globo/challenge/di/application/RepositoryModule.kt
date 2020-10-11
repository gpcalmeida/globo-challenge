package com.globo.challenge.di.application


import android.content.Context
import api.MockApi
import com.globo.domain.repository.MovieRepository
import com.globo.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import mapper.MovieMapper
import repository.MovieRepositoryImpl
import repository.UserRepositoryImpl
import storage.SessionManager
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMoviesRepository(mockApi: MockApi, movieMapper: MovieMapper, context: Context): MovieRepository {
        return MovieRepositoryImpl(mockApi = mockApi, movieMapper = movieMapper, context = context)
    }

    @Provides
    @Singleton
    fun provideUserRepository(context: Context, sessionManager: SessionManager): UserRepository {
        return UserRepositoryImpl(context = context, sessionManager = sessionManager)
    }

}