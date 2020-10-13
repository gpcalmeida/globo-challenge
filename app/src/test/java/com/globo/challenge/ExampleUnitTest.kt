package com.globo.challenge

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.globo.challenge.di.application.ApplicationComponent
import com.globo.challenge.di.application.ApplicationModule
import com.globo.challenge.presentation.BaseViewModel
import com.globo.challenge.presentation.auth.AuthRouter
import com.globo.challenge.presentation.auth.AuthViewModel
import com.globo.domain.model.User
import dagger.Module
import db.MoviesRoomDatabase
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito
import javax.inject.Inject

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

}