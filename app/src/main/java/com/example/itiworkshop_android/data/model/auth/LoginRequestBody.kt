package com.example.itiworkshop_android.data.model.auth

data class LoginRequestBody(
    val email: String,
    val password: String,
    var returnSecureToken: Boolean = true
)
