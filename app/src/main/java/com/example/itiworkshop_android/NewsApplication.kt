package com.example.itiworkshop_android

import android.app.Application
import com.example.itiworkshop_android.data.IRepository
import com.example.itiworkshop_android.data.Repository
import com.example.itiworkshop_android.data.local.LocalDataSource
import com.example.itiworkshop_android.data.local.room.ArticleDatabase
import com.example.itiworkshop_android.data.remote.RemoteSource
import com.example.itiworkshop_android.data.remote.RetrofitHelper
import com.example.itiworkshop_android.features.authentication.SharedPrefsUtil

private const val BASE_URL_AUTH = "https://identitytoolkit.googleapis.com/v1/"
private const val BASE_URL_NEWS = "https://newsapi.org/v2/top-headlines/"
class NewsApplication : Application() {
    lateinit var repository: IRepository
    override fun onCreate() {
        super.onCreate()
        SharedPrefsUtil.initialize(applicationContext)

        repository = Repository(
            remoteDataSource = RemoteSource(
                RetrofitHelper.getRetrofitAuthenticationService(BASE_URL_AUTH) ,
                RetrofitHelper.getRetrofitNewsService(BASE_URL_NEWS)
            ), SharedPrefsUtil
        )

    }
}