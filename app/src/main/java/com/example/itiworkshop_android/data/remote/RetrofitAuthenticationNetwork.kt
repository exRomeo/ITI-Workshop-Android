package com.example.itiworkshop_android.data.remote

import com.example.itiworkshop_android.data.model.auth.AuthenticationResponse
import com.example.itiworkshop_android.data.model.auth.LoginRequestBody
import com.example.itiworkshop_android.data.model.auth.RegistrationRequestBody
import com.example.itiworkshop_android.data.remote.NewsNetwork.NewsApiService
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import kotlin.jvm.Throws

//private const val BASE_URL = "https://identitytoolkit.googleapis.com/v1/"
private const val API_KEY = "AIzaSyAVRNpZKTubdM9mp3L9HaE8XGj09eNoV1o"

interface RetrofitAuthenticationService {

    @POST("./accounts:signUp?key=$API_KEY")
    suspend fun register(@Body body: RegistrationRequestBody): AuthenticationResponse.LoginResponseBody

    @POST("./accounts:signInWithPassword?key=$API_KEY")
    @Throws(HttpException::class)
    suspend fun login(@Body body: LoginRequestBody): AuthenticationResponse.LoginResponseBody

}


object RetrofitHelper {
    private lateinit var retrofitInstance : Retrofit
    private fun getRetrofitInstance(url: String): Retrofit {
         retrofitInstance =
            Retrofit
                .Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofitInstance
    }


    private fun getRetrofitOfAuthenticationService(url: String): RetrofitAuthenticationService {
        val retrofitAuthenticationService: RetrofitAuthenticationService =
            getRetrofitInstance(url).create(RetrofitAuthenticationService::class.java)
        return retrofitAuthenticationService
    }

    //    private val retrofitAuthenticationService : RetrofitAuthenticationService =
//        retrofitInstance.create(RetrofitAuthenticationService::class.java)
    private fun getRetrofitOfNewsService(url: String): NewsApiService {
        val retrofitNewsService: NewsApiService =
            getRetrofitInstance(url).create(NewsApiService::class.java)
        return retrofitNewsService
    }

    fun getRetrofitAuthenticationService(url: String): RetrofitAuthenticationService {
        return this.getRetrofitOfAuthenticationService(url)
    }

    fun getRetrofitNewsService(url: String): NewsApiService {
        return this.getRetrofitOfNewsService(url)
    }
}