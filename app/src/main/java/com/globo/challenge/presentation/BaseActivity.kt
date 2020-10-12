package com.globo.challenge.presentation

import android.app.Dialog
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.globo.challenge.BaseApplication
import com.globo.challenge.R
import com.globo.challenge.di.application.ApplicationComponent
import com.globo.challenge.di.screen.ScreenModule

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getViewModel(): BaseViewModel?

    private var dialogTransparent : Dialog? = null

    val screenComponent by lazy {
        getApplicationComponent().plus(ScreenModule(this))
    }

    private fun getApplicationComponent(): ApplicationComponent {
        return (application as BaseApplication).component
    }

    private fun showDialog(){
        dialogTransparent?.show( )
    }

    private fun hideDialog( ){
        dialogTransparent?.dismiss( )
    }

    override fun onStart() {
        super.onStart()

        dialogTransparent = Dialog(this, R.style.ThemeOverlay_AppCompat_Dark )
        val view = View.inflate(
            this, R.layout.view_loading, null )
        dialogTransparent?.requestWindowFeature( Window.FEATURE_NO_TITLE )
        dialogTransparent?.window?.setBackgroundDrawableResource( R.color.transparent )
        dialogTransparent?.setContentView( view )

        getViewModel()?.getLoadingVisibility()?.observe(this,
            Observer {
                it?.let { if(it) showDialog() else hideDialog() }
            })
    }
}