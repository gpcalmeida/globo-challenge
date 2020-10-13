package com.globo.challenge.presentation.main

import android.app.Activity
import android.os.Bundle
import com.globo.challenge.presentation.BaseRouter
import com.globo.challenge.presentation.auth.AuthActivity
import java.lang.ref.WeakReference

class MainRouter (
    private val activityRef : WeakReference<Activity>
) : BaseRouter(activityRef) {

    enum class Route {
        LOGIN
    }

    fun navigate(destination : Route, bundle : Bundle = Bundle()) {
        when(destination) {
            Route.LOGIN -> showNextScreenClearTask(AuthActivity::class.java, bundle)
        }
    }


}