package com.globo.challenge.presentation.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.globo.challenge.R
import com.globo.challenge.databinding.ActivityMainBinding
import com.globo.challenge.presentation.BaseActivity
import com.globo.challenge.presentation.BaseViewModel
import storage.SessionManager
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun getViewModel() = mainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        screenComponent.inject(this)

        binding.let {
            it.viewModel = mainViewModel
            mainViewModel.bound()
        }
    }

}