package com.example.itiworkshop_android.utility


import com.example.itiworkshop_android.utility.constant.Constant.Companion.PASSWORD_PATTERN
import com.example.itiworkshop_android.utility.constant.Constant.Companion.emailRegex
import kotlin.text.Regex

class CredentialsValidator private constructor(){
    companion object{
        private var credentialsValidator: CredentialsValidator? = null

        fun getInstance(): CredentialsValidator {
            return credentialsValidator ?: CredentialsValidator()

        }
    }


    fun isValidEmail(email: String): Boolean {
        return emailRegex.matches(email)
    }

    fun isValidPassword(password: String): Boolean {
        return PASSWORD_PATTERN.matches(password)
    }


}