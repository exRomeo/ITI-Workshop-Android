package com.example.itiworkshop_android.data.model.auth

data class LoginRequestBody(
    val email: String,
    val password: String,
    val returnSecureToken: Boolean = true
)
