package com.globo.challenge.presentation.auth

import android.app.Activity
import android.os.Bundle
import com.globo.challenge.presentation.BaseRouter
import com.globo.challenge.presentation.main.MainActivity
import java.lang.ref.WeakReference

class AuthRouter( private val activityRef : WeakReference<Activity>) : BaseRouter(activityRef) {

    enum class Route {
        MAIN
    }

    fun navigate(destination : Route, bundle : Bundle = Bundle()) {
        when(destination) {
            Route.MAIN -> { showNextScreenClearTask(MainActivity::class.java, bundle)}
        }
    }
}