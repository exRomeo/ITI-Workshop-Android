package com.example.itiworkshop_android.utility

import com.example.itiworkshop_android.data.model.Articles
import com.example.itiworkshop_android.data.model.NewsApiResponse

sealed class NewsApiState{
    class Success(val articles: List<Articles>) : NewsApiState()
    class Failure(val message: Exception) : NewsApiState()
    object Loading : NewsApiState()
}
