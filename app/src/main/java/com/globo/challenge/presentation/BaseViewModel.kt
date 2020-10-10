package com.globo.challenge.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel(
    application: Application
): AndroidViewModel(application), LifecycleObserver {

    protected val disposables = CompositeDisposable()

}

