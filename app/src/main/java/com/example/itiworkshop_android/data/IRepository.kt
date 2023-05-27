package com.example.itiworkshop_android.data

import com.example.itiworkshop_android.data.model.Article
import com.example.itiworkshop_android.data.model.auth.AuthenticationResponse
import com.example.itiworkshop_android.data.model.auth.LoginRequestBody
import com.example.itiworkshop_android.data.model.auth.RegistrationRequestBody
import kotlinx.coroutines.flow.Flow

interface IRepository {
    suspend fun register(body: RegistrationRequestBody) : AuthenticationResponse

    suspend fun login(body: LoginRequestBody) : AuthenticationResponse

//    suspend fun getNews()
    fun saveUserData(data: AuthenticationResponse.LoginResponseBody)

    fun readUserData(): AuthenticationResponse

    fun clearUserData()

    fun getAllLocalArticles() : Flow<List<Article>>

    fun insertArticle(article: Article)

    fun insertArticles(list: List<Article>)

    fun deleteArticle(article: Article)

    fun deleteArticles(list: List<Article>)
}