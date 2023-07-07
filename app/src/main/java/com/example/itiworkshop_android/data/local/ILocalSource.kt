package com.example.itiworkshop_android.data.local

import com.example.itiworkshop_android.data.model.Article
import kotlinx.coroutines.flow.Flow

interface ILocalSource {

    fun getAllLocalArticles() : Flow<List<Article>>

    suspend fun clearAllLocalArticles()

    suspend fun insertArticle(article: Article)

    suspend fun insertArticles(list: List<Article>)

    suspend fun deleteArticle(article: Article)

    suspend fun deleteArticles(list: List<Article>)

}