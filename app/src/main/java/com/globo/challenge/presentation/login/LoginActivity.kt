package com.globo.challenge.presentation.login

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.globo.challenge.R
import com.globo.challenge.databinding.ActivityLoginBinding
import com.globo.challenge.presentation.BaseActivity
import com.globo.challenge.presentation.BaseViewModel

class LoginActivity : BaseActivity() {

    override fun getViewModel(): BaseViewModel? = null

    private val loginFragment = LoginFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        screenComponent.inject(this)

        setFragmentTransaction(loginFragment)
    }

    private fun setFragmentTransaction(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .replace(R.id.loginFrameLayout, fragment)
            .commitAllowingStateLoss()
    }
}