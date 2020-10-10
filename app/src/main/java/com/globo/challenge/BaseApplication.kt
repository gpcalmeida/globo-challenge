package com.globo.challenge

import android.app.Application
import com.globo.challenge.di.application.DaggerApplicationComponent
import com.globo.challenge.di.application.ApplicationComponent
import com.globo.challenge.di.application.ApplicationModule

class BaseApplication : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        inject()
    }

    fun inject() {
        component = DaggerApplicationComponent.builder().applicationModule(
            ApplicationModule(this)
        ).build()
        component.inject(this)
    }
}