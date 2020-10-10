package com.globo.challenge.presentation

import androidx.fragment.app.Fragment
import com.globo.challenge.BaseApplication
import com.globo.challenge.di.application.ApplicationComponent
import com.globo.challenge.di.screen.ScreenModule

class BaseFragment : Fragment() {

    val screenComponent by lazy {
        getApplicationComponent().plus(ScreenModule(activity as BaseActivity))
    }
    private fun getApplicationComponent(): ApplicationComponent {
        return (activity!!.application as BaseApplication).component
    }
}