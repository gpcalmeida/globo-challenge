package com.globo.challenge.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.globo.challenge.presentation.auth.login.LoginFragment
import com.globo.challenge.presentation.auth.signup.SignUpFragment

class AuthPagerAdapter(activity : FragmentActivity) : FragmentStateAdapter(activity) {

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