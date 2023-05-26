package com.example.itiworkshop_android.data.remote

import com.example.itiworkshop_android.data.model.auth.AuthenticationResponse
import com.example.itiworkshop_android.data.model.auth.LoginRequestBody
import com.example.itiworkshop_android.data.model.auth.RegistrationRequestBody

interface IRemoteSource {
    suspend fun register(body: RegistrationRequestBody) : AuthenticationResponse
    suspend fun login(body: LoginRequestBody): AuthenticationResponse


}