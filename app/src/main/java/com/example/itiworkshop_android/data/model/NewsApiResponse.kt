package com.example.itiworkshop_android.data.model

data class NewsApiResponse(
val status:String?,
val totalResults: Int?,
val articles: List<Article>
)
