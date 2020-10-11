package com.globo.challenge.presentation.splash

import android.app.Application
import com.globo.challenge.presentation.BaseViewModel
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val splashRouter: SplashRouter,
    application: Application
) : BaseViewModel(application){

    fun bound() {
        splashRouter.navigate(SplashRouter.Route.LOGIN)
    }
}