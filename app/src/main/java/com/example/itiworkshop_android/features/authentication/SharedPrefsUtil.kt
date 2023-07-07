package com.example.itiworkshop_android.features.authentication

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.itiworkshop_android.data.model.auth.AuthenticationResponse
import kotlin.math.log

object SharedPrefsUtil {
    private const val USER_DATA = "userData"
    private const val ID_TOKEN = "idToken"
    private const val EMAIL = "email"
    private const val DISPLAY_NAME = "displayName"
    lateinit var sharedPreferences: SharedPreferences

    fun writeUserData(userData: AuthenticationResponse.LoginResponseBody) {
        Log.i("Exception", "before init ")
        if (::sharedPreferences.isInitialized) {
            Log.i("Exception", "after init ")
            val editor = sharedPreferences.edit()
            Log.i("Exception", "${userData.idToken} ")
            editor.putString(ID_TOKEN, userData.idToken)
            editor.putString(EMAIL, userData.email)
            editor.putString(DISPLAY_NAME, userData.displayName)
            editor.apply()
        }
    }

    fun readUserData(): AuthenticationResponse.LoginResponseBody? {
        val s = sharedPreferences.getString(ID_TOKEN,"SP DOESN'T EXIST")
        if( s == "SP DOESN'T EXIST"){
            return null
        }
        if (::sharedPreferences.isInitialized)
            return AuthenticationResponse.LoginResponseBody(
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

