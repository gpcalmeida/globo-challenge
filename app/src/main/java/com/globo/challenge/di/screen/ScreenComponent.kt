package com.globo.challenge.di.screen

import com.globo.challenge.presentation.main.MainActivity
import com.globo.challenge.di.scope.PerScreen
import dagger.Subcomponent

@PerScreen
@Subcomponent(modules = [ScreenModule::class])
interface ScreenComponent {

    fun inject(mainActivity: MainActivity)

}