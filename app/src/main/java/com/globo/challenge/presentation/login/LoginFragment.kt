package com.globo.challenge.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.globo.challenge.databinding.FragmentLoginBinding
import com.globo.challenge.presentation.BaseFragment
import com.globo.challenge.presentation.BaseViewModel

class LoginFragment : BaseFragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun getViewModel() = (activity as LoginActivity).getViewModel()

    lateinit var binding : FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)


        return binding.root
    }

}