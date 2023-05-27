package com.example.itiworkshop_android.data.remote.NewsNetwork

import com.example.itiworkshop_android.data.model.NewsApiResponse
import retrofit2.http.GET

private const val API_KEY = "apiKey=90183c22b7fc42e6a75df3306b79623b"
interface NewsApiService {

    @GET("?country=us&$API_KEY")
    suspend fun getAllNews(): NewsApiResponse
}
