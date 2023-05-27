package com.example.itiworkshop_android.data

import com.example.itiworkshop_android.data.model.Article
import com.example.itiworkshop_android.data.model.auth.AuthenticationResponse
import com.example.itiworkshop_android.data.model.auth.LoginRequestBody
import com.example.itiworkshop_android.data.model.auth.RegistrationRequestBody
import com.example.itiworkshop_android.utility.NewsApiState
import kotlinx.coroutines.flow.Flow

interface IRepository {
    suspend fun register(body: RegistrationRequestBody): AuthenticationResponse

    suspend fun login(body: LoginRequestBody): AuthenticationResponse
    suspend fun getAllNews(): NewsApiState

//    suspend fun getNews()
    fun saveUserData(data: AuthenticationResponse.LoginResponseBody)

    fun readUserData(): AuthenticationResponse

    fun clearUserData()

    fun getAllLocalArticles() : Flow<List<Article>>

    suspend fun insertArticle(article: Article)

    suspend fun insertArticles(list: List<Article>)

    suspend fun deleteArticle(article: Article)

    suspend fun deleteArticles(list: List<Article>)
}