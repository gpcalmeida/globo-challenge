package com.globo.challenge.presentation.main

import android.os.Bundle
import com.globo.challenge.R
import com.globo.challenge.presentation.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        screenComponent.inject(this)
    }

}