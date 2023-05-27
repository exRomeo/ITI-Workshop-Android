package com.example.itiworkshop_android.data.remote.NewsNetwork

import android.content.Context
import com.example.itiworkshop_android.utility.NetworkConnection
import okhttp3.Cache
import okhttp3.OkHttpClient


object HttpClient {
    val cacheSize = (5 * 1024 * 1024).toLong()
    lateinit var okHttpClient: OkHttpClient
    fun setUpOKHttp(context: Context) {
        val myCache = Cache(context.cacheDir, cacheSize)
        okHttpClient = OkHttpClient.Builder()
            .cache(myCache)
            .addInterceptor { chain ->
                var request = chain.request()
             //   request = //if (NetworkConnection.hasNetwork(context) != true)
                    request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
//                else
//                    request.newBuilder().header(
//                        "Cache-Control",
//                        "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7
//                    ).build()
                chain.proceed(request)
            }
            .build()
    }


}