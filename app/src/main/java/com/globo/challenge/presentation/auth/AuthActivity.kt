package com.globo.challenge.presentation.auth

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.globo.challenge.R
import com.globo.challenge.databinding.ActivityLoginBinding
import com.globo.challenge.presentation.BaseActivity
import com.globo.challenge.presentation.adapter.AuthPagerAdapter
import javax.inject.Inject


class AuthActivity : BaseActivity() {

    @Inject
    lateinit var authViewModel : AuthViewModel

    override fun getViewModel() = authViewModel

    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        screenComponent.inject(this)

        binding.loginViewPager.adapter = AuthPagerAdapter(activity = this)
        binding.loginViewPager.isUserInputEnabled = false
    }

    fun openLogin() {
        binding.loginViewPager.currentItem = 0
    }

    fun openSignUp() {
        binding.loginViewPager.currentItem = 1
    }

}