package com.globo.challenge.presentation.splash

import android.os.Bundle
import com.globo.challenge.presentation.BaseActivity
import javax.inject.Inject

class SplashActivity : BaseActivity() {

    @Inject
    lateinit var splashViewModel: SplashViewModel

    override fun getViewModel() = splashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        screenComponent.inject(this)

        splashViewModel.bound()
    }
}