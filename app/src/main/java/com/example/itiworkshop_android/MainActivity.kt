package com.example.itiworkshop_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val TAG: String = "Exception"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val key = BuildConfig.API_KEY
        Log.i("TAG", "onCreate: $key")
        setContentView(R.layout.activity_main)
    }
}