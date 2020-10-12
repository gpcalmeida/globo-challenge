package com.globo.challenge.presentation.splash

import android.app.Application
import com.globo.challenge.presentation.BaseViewModel
import com.globo.domain.usecase.session.GetSavedUserUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val splashRouter: SplashRouter,
    private val getSavedUserUseCase: GetSavedUserUseCase,
    application: Application
) : BaseViewModel(application){

    fun bound() {
        GlobalScope.launch {
            val user = getSavedUserUseCase.execute()
            user?.let {
                splashRouter.navigate(SplashRouter.Route.MAIN)
            } ?: splashRouter.navigate(SplashRouter.Route.LOGIN)
        }
    }
}