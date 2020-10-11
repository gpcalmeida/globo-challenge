package storage

import android.app.Application
import javax.inject.Inject

class SessionManager @Inject constructor(
    application: Application
) : SharedPreferencesHelper(application) {

    companion object {
        const val PASSWORD = "password"
        const val USER = "user"
    }

    fun setUser(user : String) {
        putString(USER, user)
    }

    fun getUser() : String? {
        return getString(USER)
    }

    fun setPassword(password : String) {
        putString(PASSWORD, password)
    }

    fun getPassword() : String? {
        return getString(PASSWORD)
    }

    fun logout() = erase()
}