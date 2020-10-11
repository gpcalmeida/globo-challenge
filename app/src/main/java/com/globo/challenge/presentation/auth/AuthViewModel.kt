package com.globo.challenge.presentation.auth

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.globo.challenge.presentation.BaseViewModel
import com.globo.domain.model.User
import com.globo.domain.session.SaveUserUseCase
import com.globo.domain.usecase.user.GetUserUseCase
import com.globo.domain.usecase.user.InsertUserUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val router : AuthRouter,
    private val getUserUseCase: GetUserUseCase,
    private val insertUserUseCase: InsertUserUseCase,
    private val saveUserUseCase: SaveUserUseCase,
    application: Application
) : BaseViewModel(application) {

    private val openSignUpFragment = MutableLiveData<Boolean>().apply { value = false }
    fun getOpenSignUpFragment() : LiveData<Boolean> = openSignUpFragment

    private val openLoginFragment = MutableLiveData<Boolean>().apply { value = false }
    fun getOpenLoginFragment() : LiveData<Boolean> = openLoginFragment

    val user = MutableLiveData<String>().apply { value = null }
    val password = MutableLiveData<String>().apply { value = null }
    val confirmPassword = MutableLiveData<String>().apply { value = null }

    val userEmptyError = MutableLiveData<Boolean>().apply { value = false }
    val passwordEmptyError = MutableLiveData<Boolean>().apply { value = false }
    val confirmPasswordEmptyError = MutableLiveData<Boolean>().apply { value = false }
    val passwordsNotMatching = MutableLiveData<Boolean>().apply { value = false }

    val loginUser = MutableLiveData<String>().apply { value = null }
    val loginPassword = MutableLiveData<String>().apply { value = null }

    val loginUserEmptyError = MutableLiveData<Boolean>().apply { value = false }
    val loginPasswordEmptyError = MutableLiveData<Boolean>().apply { value = false }
    val unableAuthenticate = MutableLiveData<Boolean>().apply { value = false }

    fun onSignUpClicked() {
        openSignUpFragment.postValue(true)
    }

    fun onLoginClicked() {
        openLoginFragment.postValue(true)
    }

    fun onConfirmClick() {
        val user = user.value ?: ""
        val password = password.value ?: ""
        val confirmPassword = confirmPassword.value ?: ""

        when {
            user.isEmpty() -> { userEmptyError.postValue(true) }
            password.isEmpty() -> { passwordEmptyError.postValue(true) }
            confirmPassword.isEmpty() -> { confirmPasswordEmptyError .postValue(true) }
            password != confirmPassword -> { passwordsNotMatching.postValue(true) }
            else -> { signUpUser( User(user, password)) }
        }
    }

    private fun signUpUser(user : User) {
        GlobalScope.launch {
            insertUserUseCase.execute(user)
            val auth = getUserUseCase.execute(user)

            auth.let {
                saveUserUseCase.execute(auth)
                router.navigate(AuthRouter.Route.MAIN)
            }
        }
    }

    fun onEnterClicked() {
        val user = loginUser.value ?: ""
        val password = loginPassword.value ?: ""

        when {
            user.isEmpty() -> { loginUserEmptyError.postValue(true) }
            password.isEmpty() -> { loginPasswordEmptyError.postValue(true) }
            else -> { doLogin( User(user, password)) }
        }
    }

    private fun doLogin(user : User) {
        var auth : User? = null
        GlobalScope.launch {
            auth = getUserUseCase.execute(user)

            auth?.let {
                saveUserUseCase.execute(auth!!)
                router.navigate(AuthRouter.Route.MAIN)
            } ?: unableAuthenticate.postValue(true)

        }
    }

}