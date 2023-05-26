package com.example.itiworkshop_android.data.model.auth

sealed class AuthenticationResponse{

    class LoginResponseBody(
        val idToken: String?= null,
        val email: String?=null,
        val displayName: String?=null
    ) : AuthenticationResponse()

    class Error(
        var code: Int = 200,
        var message: String = "Success"
    ) : AuthenticationResponse()

}