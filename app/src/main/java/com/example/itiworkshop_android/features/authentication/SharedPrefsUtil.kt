package com.example.itiworkshop_android.features.authentication

import android.content.Context
import android.content.SharedPreferences

object SharedPrefsUtil {
    private const val USER_DATA = "userData"
    private const val ID_TOKEN = "idToken"
    private const val EMAIL = "email"
    private const val DISPLAY_NAME = "displayName"
    lateinit var sharedPreferences: SharedPreferences

    fun writeUserData(userData: LoginResponseBody) {
        if (::sharedPreferences.isInitialized) {
            val editor = sharedPreferences.edit()
            editor.putString(ID_TOKEN, userData.idToken)
            editor.putString(EMAIL, userData.email)
            editor.putString(DISPLAY_NAME, userData.displayName)
            editor.apply()
        }
    }

    fun readUserData(): LoginResponseBody? {
        if (::sharedPreferences.isInitialized)
            return LoginResponseBody(
                idToken = sharedPreferences.getString(ID_TOKEN, ""),
                email = sharedPreferences.getString(EMAIL, ""),
                displayName = sharedPreferences.getString(DISPLAY_NAME, "")
            )
        return null
    }

    fun clearUserData() {
        if (::sharedPreferences.isInitialized)
            sharedPreferences.edit().clear().apply()
    }


    fun initialize(context: Context) {
        this.sharedPreferences = context.getSharedPreferences(USER_DATA, Context.MODE_PRIVATE)
    }
}

