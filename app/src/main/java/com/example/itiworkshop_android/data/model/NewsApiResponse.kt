package com.example.itiworkshop_android.data.model

data class NewsApiResponse(
val status:String?,
val totalResults: Int?,
val articles: List<Articles>
) {
}

data class Articles(
    val source: Source?,
    val author: String?,
    val title: String?,
    val description:String?,
    val url: String?,
    val urlToImage:String?,
    val publishedAt: String?,
    val content: String?
)

data class Source(
    val id:String?,
    val name: String?
)