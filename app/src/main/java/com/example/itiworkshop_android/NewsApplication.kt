package com.example.itiworkshop_android

import android.app.Application
import com.example.itiworkshop_android.data.IRepository
import com.example.itiworkshop_android.data.Repository
import com.example.itiworkshop_android.data.local.LocalDataSource
import com.example.itiworkshop_android.data.local.room.ArticleDatabase
import com.example.itiworkshop_android.data.remote.RemoteSource
import com.example.itiworkshop_android.data.remote.RetrofitAuthenticationHelper
import com.example.itiworkshop_android.features.authentication.SharedPrefsUtil

class NewsApplication : Application() {
    lateinit var repository: IRepository
    override fun onCreate() {
        super.onCreate()
        SharedPrefsUtil.initialize(applicationContext)
        repository =
            Repository(
                remoteDataSource = RemoteSource(RetrofitAuthenticationHelper.getRetrofitAuthenticationService()),
                sharedPrefsUtil = SharedPrefsUtil,
                localDataSource = LocalDataSource(ArticleDatabase.getInstance(this.applicationContext))
            )
    }
}