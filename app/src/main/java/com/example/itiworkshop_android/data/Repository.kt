package com.example.itiworkshop_android.data

import com.example.itiworkshop_android.data.local.ILocalSource
import com.example.itiworkshop_android.data.local.LocalDataSource
import com.example.itiworkshop_android.data.model.Article
import com.example.itiworkshop_android.data.model.auth.AuthenticationResponse
import com.example.itiworkshop_android.data.model.auth.LoginRequestBody
import com.example.itiworkshop_android.data.model.auth.RegistrationRequestBody
import com.example.itiworkshop_android.data.remote.IRemoteSource
import com.example.itiworkshop_android.features.authentication.SharedPrefsUtil
import com.example.itiworkshop_android.utility.NewsApiState
import kotlinx.coroutines.flow.Flow

class Repository(/*private val localDataSource: ILocalSource,*/
                 private val remoteDataSource: IRemoteSource,
                 private val sharedPrefsUtil: SharedPrefsUtil,
                 private val localDataSource: ILocalSource
) : IRepository {


    override suspend fun register(body: RegistrationRequestBody): AuthenticationResponse {
        return remoteDataSource.register(body)
    }

    override suspend fun login(body: LoginRequestBody): AuthenticationResponse {
        return remoteDataSource.login(body)
    }

    override suspend fun getAllNews(): NewsApiState {
        return remoteDataSource.getAllNews()
    }


    override fun saveUserData(data: AuthenticationResponse.LoginResponseBody) {
        sharedPrefsUtil.writeUserData(data)
    }

    override fun readUserData(): AuthenticationResponse {
        val data = sharedPrefsUtil.readUserData()
        if (data != null)
            return AuthenticationResponse.LoginResponseBody(
                data.idToken,
                data.email,
                data.displayName
            )
        else
            return AuthenticationResponse.Error(-200, "Please Login")
    }

    override fun clearUserData() {
        sharedPrefsUtil.clearUserData()
        localDataSource.clearAllLocalArticles()
    }

    override fun getAllLocalArticles(): Flow<List<Article>> = localDataSource.getAllLocalArticles()

    override fun insertArticle(article: Article) = localDataSource.insertArticle(article)

    override suspend fun insertArticles(list: List<Article>) = localDataSource.insertArticles(list)

    override fun deleteArticle(article: Article) = localDataSource.deleteArticle(article)

    override fun deleteArticles(list: List<Article>) = localDataSource.deleteArticles(list)
}