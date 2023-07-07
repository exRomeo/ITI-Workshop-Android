package com.example.itiworkshop_android.data.model.auth

sealed class AuthenticationResponse{

    class Loading() : AuthenticationResponse()
    class LoginResponseBody(
        val idToken: String?,
        val email: String?,
        val displayName: String?
    ) : AuthenticationResponse()

    class Error(
        val code: Int = 200,
        val message: String = "Success"
    ) : AuthenticationResponse()

}