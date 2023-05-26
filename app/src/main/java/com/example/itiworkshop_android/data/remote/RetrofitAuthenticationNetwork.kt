package com.example.itiworkshop_android.data.remote

import com.example.itiworkshop_android.data.model.auth.AuthenticationResponse
import com.example.itiworkshop_android.data.model.auth.LoginRequestBody
import com.example.itiworkshop_android.data.model.auth.RegistrationRequestBody
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import kotlin.jvm.Throws

private const val BASE_URL = "https://identitytoolkit.googleapis.com/v1/"
private const val API_KEY = "AIzaSyAVRNpZKTubdM9mp3L9HaE8XGj09eNoV1o"

interface RetrofitAuthenticationService{

    @POST("./accounts:signUp?key=$API_KEY")
    suspend fun register(@Body body: RegistrationRequestBody) : AuthenticationResponse.LoginResponseBody

    @POST("./accounts:signInWithPassword?key=$API_KEY")
    @Throws(HttpException::class)
    suspend fun login(@Body body: LoginRequestBody) : AuthenticationResponse.LoginResponseBody
}



object RetrofitAuthenticationHelper{
    private val retrofitInstance: Retrofit =
        Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitAuthenticationService : RetrofitAuthenticationService =
        retrofitInstance.create(RetrofitAuthenticationService::class.java)

    fun getRetrofitAuthenticationService() : RetrofitAuthenticationService{
        return this.retrofitAuthenticationService
    }
}