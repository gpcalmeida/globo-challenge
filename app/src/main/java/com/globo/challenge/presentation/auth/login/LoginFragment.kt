package com.globo.challenge.presentation.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.globo.challenge.R
import com.globo.challenge.databinding.FragmentLoginBinding
import com.globo.challenge.presentation.BaseFragment
import com.globo.challenge.presentation.auth.AuthActivity

class LoginFragment : BaseFragment() {

    companion object {
        fun newInstance() =
            LoginFragment()
    }

    override fun getViewModel() = (activity as AuthActivity).getViewModel()

    lateinit var binding : FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.let {
            it.viewModel = getViewModel()
            it.lifecycleOwner = activity
        }

        setupObservers()
        return binding.root
    }

    private fun setupObservers() {
        getViewModel().getOpenSignUpFragment().observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it) {
                    (activity as AuthActivity).openSignUp()
                }
            }
        })

        getViewModel().loginUserEmptyError.observe(viewLifecycleOwner, Observer {
            it?.let { userEmpty ->
                if(userEmpty) {
                    binding.userEditText.error = getString(R.string.fill_field)
                }
            }
        })

        getViewModel().loginPasswordEmptyError.observe(viewLifecycleOwner, Observer {
            it?.let { passwordEmpty ->
                if(passwordEmpty) {
                    binding.passwordEditText.error = getString(R.string.fill_field)
                }
            }
        })

        getViewModel().unableAuthenticate.observe(viewLifecycleOwner, Observer {
            it?.let { unableAuthenticate ->
                if(unableAuthenticate) {
                    binding.userEditText.error = getString(R.string.unable_to_auth)
                }
            }
        })

        getViewModel().loginWrongPasswordError.observe(viewLifecycleOwner, Observer {
            it?.let { wrongPassword ->
                if(wrongPassword) {
                    binding.passwordEditText.error = getString(R.string.wrong_password)
                }
            }
        })
    }
}