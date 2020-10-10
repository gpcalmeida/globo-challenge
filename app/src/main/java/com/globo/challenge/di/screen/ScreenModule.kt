package com.globo.challenge.di.screen

import com.globo.challenge.di.scope.PerScreen
import com.globo.challenge.presentation.BaseActivity
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

//    @PerScreen
//    @Provides
//    fun providesLoginRouter(): LoginRouter{
//        return LoginRouter(WeakReference(activity))
//    }

}