package com.example.itiworkshop_android.data.model.auth

data class RegistrationRequestBody(
    val email: String,
    val password: String,
    val displayName: String,
    val returnSecureToken: Boolean?=true
)
