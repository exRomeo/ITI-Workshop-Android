package com.example.itiworkshop_android.data.local

import com.example.itiworkshop_android.data.model.Article
import kotlinx.coroutines.flow.Flow

interface ILocalSource {

    fun getAllLocalArticles() : Flow<List<Article>>

    fun clearAllLocalArticles()

    fun insertArticle(article: Article)

    suspend fun insertArticles(list: List<Article>)

    fun deleteArticle(article: Article)

    fun deleteArticles(list: List<Article>)

}