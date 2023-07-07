package com.example.itiworkshop_android.utility

import com.example.itiworkshop_android.data.model.Article
import com.example.itiworkshop_android.data.model.NewsApiResponse

sealed class NewsApiState{
    class Success(val articles: List<Article>) : NewsApiState()
    class Failure(val message: Exception) : NewsApiState()
    object Loading : NewsApiState()
}
