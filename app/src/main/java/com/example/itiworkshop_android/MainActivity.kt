package com.example.itiworkshop_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.itiworkshop_android.data.model.auth.AuthenticationResponse
import com.example.itiworkshop_android.data.model.auth.LoginRequestBody
import com.example.itiworkshop_android.data.model.auth.RegistrationRequestBody

class MainActivity : AppCompatActivity() {

    private val TAG: String = "Exception"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}