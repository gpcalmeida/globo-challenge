package com.globo.challenge.presentation.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.globo.challenge.R
import com.globo.challenge.databinding.FragmentProfileBinding
import com.globo.challenge.presentation.BaseFragment
import com.globo.challenge.presentation.adapter.ProfileAdapter
import com.globo.challenge.presentation.main.MainActivity
import com.globo.challenge.presentation.main.profile.changepassword.ChangePasswordDialogFragment

class ProfileFragment : BaseFragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    override fun getViewModel() = (activity as MainActivity).getViewModel()

    lateinit var binding : FragmentProfileBinding

    private val profileAdapter = ProfileAdapter(listOf(R.string.change_password, R.string.logout))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.let {
            it.viewModel = getViewModel()
            it.lifecycleOwner = activity

            with(it.profileRecyclerView) {
                adapter = profileAdapter.apply {
                    onItemClickedListener ={ option ->
                        when(option) {
                            R.string.change_password -> {
                                ChangePasswordDialogFragment { newPassword ->
                                    getViewModel().onChangePasswordCalled(newPassword)
                                }.show(activity!!.supportFragmentManager, "")
                            }
                            R.string.logout -> { getViewModel().onLogoutClicked() }
                        }
                    }
                }
                layoutManager = LinearLayoutManager(activity)
            }
        }

        getViewModel().getCurrentUser().observe(viewLifecycleOwner, Observer {
            it?.let { username ->
                binding.userNameTextView.text = String.format("%s!", username)
            }
        })

        return binding.root
    }

}