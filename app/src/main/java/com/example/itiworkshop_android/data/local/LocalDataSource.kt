package com.example.itiworkshop_android.data.local

import com.example.itiworkshop_android.data.local.room.ArticleDao
import com.example.itiworkshop_android.data.local.room.ArticleDatabase
import com.example.itiworkshop_android.data.model.Article
import kotlinx.coroutines.flow.Flow

class LocalDataSource(
    private val articleDatabase: ArticleDatabase
) : ILocalSource{

    private val articleDao : ArticleDao = articleDatabase.getArticleDao()

    override fun getAllLocalArticles(): Flow<List<Article>> = articleDao.getAllLocalArticles()

    override suspend fun clearAllLocalArticles() = articleDao.clearAllLocalArticles()
    override suspend fun insertArticle(article: Article) =  articleDao.insertArticle(article)

    override suspend fun insertArticles(list: List<Article>) = articleDao.insertArticles(list)

    override suspend fun deleteArticle(article: Article) = articleDao.deleteArticle(article)

    override suspend fun deleteArticles(list: List<Article>) = articleDao.deleteArticles(list)

}