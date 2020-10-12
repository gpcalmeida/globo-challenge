package repository

import android.content.Context
import com.globo.domain.model.User
import com.globo.domain.repository.UserRepository
import db.MoviesRoomDatabase
import storage.SessionManager
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val context: Context,
    private val sessionManager: SessionManager
) : UserRepository {

    override suspend fun registerUser(user: User) {
        MoviesRoomDatabase.getDatabase(context).userDao().insertUser(user)
    }

    override suspend fun getUser(user: String): User {
        return MoviesRoomDatabase.getDatabase(context).userDao().getUser(user)
    }

    override fun getSavedUser(): String? {
        return sessionManager.getUser()
    }

    override fun saveUser(user: User) {
        sessionManager.setUser(user.user)
        sessionManager.setPassword(user.password)
    }

    override fun logout() {
        sessionManager.logout()
    }
}