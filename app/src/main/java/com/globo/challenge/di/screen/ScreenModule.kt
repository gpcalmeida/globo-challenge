package com.globo.challenge.di.screen

import com.globo.challenge.di.scope.PerScreen
import com.globo.challenge.presentation.BaseActivity
import com.globo.challenge.presentation.auth.AuthRouter
import com.globo.challenge.presentation.splash.SplashRouter
import dagger.Module
import dagger.Provides
import java.lang.ref.WeakReference

@Module
class ScreenModule(private val activity: BaseActivity) {

    @PerScreen
    @Provides
    fun providesActivity(): BaseActivity {
        return activity
    }

    @PerScreen
    @Provides
    fun providesSplashRouter(): SplashRouter {
        return SplashRouter(WeakReference(activity))
    }

    @PerScreen
    @Provides
    fun providesAuthRouter(): AuthRouter {
        return AuthRouter(WeakReference(activity))
    }

}