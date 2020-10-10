package com.globo.challenge.di.application

import api.MockEndPoint
import dagger.*
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class EndPointModule {

    @Provides
    @Singleton
    fun provideMockEndpoint(retrofit: Retrofit) : MockEndPoint{
        return retrofit.create(MockEndPoint::class.java)
    }

}