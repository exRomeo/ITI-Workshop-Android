package com.example.itiworkshop_android.data

import com.example.itiworkshop_android.data.model.auth.AuthenticationResponse
import com.example.itiworkshop_android.data.model.auth.LoginRequestBody
import com.example.itiworkshop_android.data.model.auth.RegistrationRequestBody
import com.example.itiworkshop_android.utility.NewsApiState

interface IRepository {
    suspend fun register(body: RegistrationRequestBody): AuthenticationResponse

    suspend fun login(body: LoginRequestBody): AuthenticationResponse
    suspend fun getAllNews(): NewsApiState

    fun saveUserData(data: AuthenticationResponse.LoginResponseBody)

    fun readUserData(): AuthenticationResponse

    fun clearUserData()
}