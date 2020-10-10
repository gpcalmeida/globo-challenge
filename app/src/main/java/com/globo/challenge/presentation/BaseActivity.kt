package com.globo.challenge.presentation

import androidx.appcompat.app.AppCompatActivity
import com.globo.challenge.BaseApplication
import com.globo.challenge.di.application.ApplicationComponent
import com.globo.challenge.di.screen.ScreenModule

abstract class BaseActivity : AppCompatActivity() {

    val screenComponent by lazy {
        getApplicationComponent().plus(ScreenModule(this))
    }

    private fun getApplicationComponent(): ApplicationComponent {
        return (application as BaseApplication).component
    }
}