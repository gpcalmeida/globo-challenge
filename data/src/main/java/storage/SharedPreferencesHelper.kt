package storage

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

open class SharedPreferencesHelper constructor(application: Application){
    private val prefId : String = "APP_PREFERENCES"
    private var settings : SharedPreferences? = null
    private var editor : SharedPreferences.Editor? = null

    init {
        settings = application.getSharedPreferences(prefId, Context.MODE_PRIVATE)
    }

    fun putString(key : String, string : String){
        settings?.edit()?.putString(key, string)?.apply()
    }

    fun getString(key : String) : String? {
        return settings?.getString(key, null)
    }

    open fun erase(){
        editor = settings?.edit()
        editor?.clear()?.apply()
    }
}