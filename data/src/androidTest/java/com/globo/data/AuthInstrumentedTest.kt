package com.globo.data

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.globo.domain.model.User
import db.MoviesRoomDatabase

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class AuthInstrumentedTest {

    private val context = ApplicationProvider.getApplicationContext<Context>()
    private val room = MoviesRoomDatabase.getDatabase(context)

    @Test
    fun should_Insert_User_In_Database() {
        val user = User("gustavo", "12345")
        val isSignedUp = room.userDao().insertUser(user)
        assertEquals(isSignedUp, 1)
    }

    @Test
    fun should_Throw_Room_Exception() {
        try {
            val user = User("gustavo", "12345")
             room.userDao().insertUser(user)
        } catch ( exception : Throwable ) {
            assertTrue(exception is android.database.sqlite.SQLiteConstraintException)
        }
    }

    @Test
    fun should_Return_Inserted_User() {
        val user = "gustavo"
        val dbUser = room.userDao().getUser(user)
        assertEquals(dbUser, User("gustavo", "123456"))
    }

    @Test
    fun should_Not_Return_Inserted_User() {
        val user = ""
        val dbUser = room.userDao().getUser(user)
        assertEquals(dbUser, null)
    }

    @Test
    fun should_Update_User_Password() {
        val user = "gustavo"
        val newPassword = "123456"
        val updatedUser = room.userDao().updatePassword(user, newPassword)
        assertNotNull(updatedUser)
    }
}