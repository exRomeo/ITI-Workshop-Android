package com.example.itiworkshop_android

import android.app.Application
import com.example.itiworkshop_android.features.authentication.SharedPrefsUtil

class NewsApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPrefsUtil.initialize(applicationContext)
    }
}