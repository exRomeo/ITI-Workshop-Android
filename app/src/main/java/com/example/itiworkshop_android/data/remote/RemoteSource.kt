package com.example.itiworkshop_android.data.remote

import com.example.itiworkshop_android.data.model.auth.AuthenticationResponse
import com.example.itiworkshop_android.data.model.auth.LoginRequestBody
import com.example.itiworkshop_android.data.model.auth.RegistrationRequestBody
import com.example.itiworkshop_android.data.remote.NewsNetwork.NewsApiService
import com.example.itiworkshop_android.utility.NewsApiState
import retrofit2.HttpException
import java.lang.Exception

class RemoteSource(private val apiService: RetrofitAuthenticationService , private val newsApiService: NewsApiService): IRemoteSource {
    override suspend fun register(body: RegistrationRequestBody): AuthenticationResponse {
        return try {
            apiService.register(body)
        } catch (error: HttpException){
            AuthenticationResponse.Error(-200, "Use a Different Email!")
        }
    }

    override suspend fun login(body: LoginRequestBody): AuthenticationResponse {
        return try {
            apiService.login(body)
        } catch (error: HttpException){
            AuthenticationResponse.Error(-200, "Incorrect Email or Password")
        }

    }

    override suspend fun getAllNews(): NewsApiState {
        return try {
            val articles = newsApiService.getAllNews().articles
            NewsApiState.Success(articles)
        } catch (ex: Exception) {
            NewsApiState.Failure(ex)
        }
    }
}