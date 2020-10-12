package com.globo.challenge.presentation.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.globo.challenge.databinding.FragmentProfileBinding
import com.globo.challenge.presentation.BaseFragment
import com.globo.challenge.presentation.main.MainActivity

class ProfileFragment : BaseFragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    override fun getViewModel() = (activity as MainActivity).getViewModel()

    lateinit var binding : FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.let {
            it.viewModel = getViewModel()
            it.lifecycleOwner = activity
        }

        return binding.root
    }

}