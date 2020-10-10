package com.globo.challenge.di.application

import dagger.Component
import com.globo.challenge.di.screen.ScreenComponent
import com.globo.challenge.di.screen.ScreenModule
import com.globo.challenge.BaseApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, RepositoryModule::class, EndPointModule::class])
interface ApplicationComponent {

    fun inject(activity: BaseApplication)

    fun plus(screenModule: ScreenModule): ScreenComponent
}