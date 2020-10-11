package com.globo.challenge.presentation.splash

import android.app.Activity
import android.os.Bundle
import com.globo.challenge.presentation.BaseRouter
import com.globo.challenge.presentation.login.LoginActivity
import com.globo.challenge.presentation.main.MainActivity
import java.lang.ref.WeakReference

class SplashRouter(
    private val activityRef: WeakReference<Activity>
): BaseRouter(activityRef) {

    enum class Route {
        LOGIN,
        MAIN
    }

    fun navigate(destination : Route, bundle : Bundle = Bundle()) {
        when(destination) {
            Route.LOGIN -> { showNextScreenClearTask(LoginActivity::class.java, bundle) }
            Route.MAIN -> { showNextScreenClearTask(MainActivity::class.java, bundle)}
        }
    }
}