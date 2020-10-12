package com.globo.challenge.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel(
    application: Application
): AndroidViewModel(application), LifecycleObserver {

    protected val disposables = CompositeDisposable()

    private val loadingVisibility = MutableLiveData<Boolean>().apply { value = false }
    fun getLoadingVisibility(): LiveData<Boolean> = loadingVisibility

    fun showDialog(){
        loadingVisibility.postValue(true)
    }

    fun hideDialog(){
        loadingVisibility.postValue(false)
    }

}

