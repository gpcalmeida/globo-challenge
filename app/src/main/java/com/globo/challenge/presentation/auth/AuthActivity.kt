package com.globo.challenge.presentation.auth

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.globo.challenge.R
import com.globo.challenge.databinding.ActivityLoginBinding
import com.globo.challenge.presentation.BaseActivity
import com.globo.challenge.presentation.auth.login.LoginFragment
import com.globo.challenge.presentation.auth.signup.SignUpFragment
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

        binding.loginViewPager.adapter = PagerAdapter(activity = this)
        binding.loginViewPager.isUserInputEnabled = false
    }

    fun openLogin() {
        binding.loginViewPager.currentItem = 0
    }

    fun openSignUp() {
        binding.loginViewPager.currentItem = 1
    }


    private class PagerAdapter(activity : FragmentActivity) : FragmentStateAdapter(activity) {

        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> LoginFragment.newInstance()
                1 -> SignUpFragment.newInstance()
                else -> Fragment()
            }
        }
    }

}