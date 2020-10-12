package com.globo.domain.repository

import com.globo.domain.model.User

interface UserRepository {

    suspend fun registerUser(user : User)

    suspend fun getUser(user : String) : User

    suspend fun updatePassword(user: String, password: String)

    fun saveUser(user : User)

    fun getSavedUser() : String?

    fun logout()

}