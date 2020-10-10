package com.globo.challenge.presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import java.lang.ref.WeakReference

open class BaseRouter(private val activityRef: WeakReference<Activity>){

    fun goBack(){
        activityRef.get()?.onBackPressed()
    }

    internal open fun showNextScreen(clazz: Class<*>, bundle: Bundle?) {
        activityRef.get()?.startActivity(Intent(activityRef.get(), clazz).putExtras(bundle!!))
    }

    internal open fun showNextScreenClearTask(clazz: Class<*>, bundle: Bundle?) {
        val intent = Intent(activityRef.get(), clazz)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_TASK_ON_HOME)
        intent.putExtras(bundle!!)
        activityRef.get()?.startActivity(intent)
    }
}