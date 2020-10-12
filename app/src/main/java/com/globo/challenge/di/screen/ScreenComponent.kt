package com.globo.challenge.di.screen

import com.globo.challenge.presentation.main.MainActivity
import com.globo.challenge.di.scope.PerScreen
import com.globo.challenge.presentation.auth.AuthActivity
import com.globo.challenge.presentation.auth.login.LoginFragment
import com.globo.challenge.presentation.auth.signup.SignUpFragment
import com.globo.challenge.presentation.main.movies.MoviesFragment
import com.globo.challenge.presentation.splash.SplashActivity
import dagger.Subcomponent

@PerScreen
@Subcomponent(modules = [ScreenModule::class])
interface ScreenComponent {

    fun inject(splashActivity: SplashActivity)
    fun inject(mainActivity: MainActivity)
    fun inject(authActivity: AuthActivity)
    fun inject(loginFragment: LoginFragment)
    fun inject(signUpFragment: SignUpFragment)
    fun inject(moviesFragment: MoviesFragment)


}