package com.example.itiworkshop_android.data.model.auth

data class RegisterationRequestBody(
    val email: String,
    val password: String,
    val displayName: String,
    var returnSecureToken: Boolean = true
)
