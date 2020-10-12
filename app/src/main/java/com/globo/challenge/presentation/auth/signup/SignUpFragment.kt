package com.globo.challenge.presentation.auth.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.globo.challenge.R
import com.globo.challenge.databinding.FragmentSignupBinding
import com.globo.challenge.presentation.BaseFragment
import com.globo.challenge.presentation.auth.AuthActivity

class SignUpFragment : BaseFragment() {

    companion object {
        fun newInstance() =
            SignUpFragment()
    }

    override fun getViewModel() = (activity as AuthActivity).getViewModel()

    lateinit var binding : FragmentSignupBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupBinding.inflate(inflater, container, false)

        binding.let {
            it.viewModel = getViewModel()
            it.lifecycleOwner = activity
        }

        setupObservers()

        return binding.root
    }

    private fun setupObservers() {

        getViewModel().getOpenLoginFragment().observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it) {
                    (activity as AuthActivity).openLogin()
                }
            }
        })

        getViewModel().userEmptyError.observe(viewLifecycleOwner, Observer {
            it?.let { userEmpty ->
                if(userEmpty) {
                    binding.userEditText.error = getString(R.string.fill_field)
                }
            }
        })

        getViewModel().passwordEmptyError.observe(viewLifecycleOwner, Observer {
            it?.let { passwordEmpty ->
                if(passwordEmpty) {
                    binding.passwordEditText.error = getString(R.string.fill_field)
                }
            }
        })

        getViewModel().confirmPasswordEmptyError.observe(viewLifecycleOwner, Observer {
            it?.let { confirmPassword ->
                if(confirmPassword) {
                    binding.confirmPasswordEditText.error = getString(R.string.fill_field)
                }
            }
        })

        getViewModel().passwordsNotMatching.observe(viewLifecycleOwner, Observer {
            it?.let { notMatching ->
                if(notMatching) {
                    binding.passwordEditText.error = getString(R.string.pass_not_matching)
                    binding.confirmPasswordEditText.error = getString(R.string.pass_not_matching)
                }
            }
        })

        getViewModel().registeredUserError.observe(viewLifecycleOwner, Observer {
            it?.let { registeredUser ->
                if(registeredUser) {
                    binding.userEditText.error = getString(R.string.user_already_registered)
                }
            }
        })
    }

}