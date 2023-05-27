package com.example.itiworkshop_android.features.home.news.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.itiworkshop_android.data.IRepository
import com.example.itiworkshop_android.data.Repository
import com.example.itiworkshop_android.data.model.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NewsViewModel(val repository: IRepository) : ViewModel() {
    private var _articleList: MutableStateFlow<List<Article>> = MutableStateFlow(listOf())
    val articleList = _articleList.asStateFlow()
    init {
        getArticles()
    }
    fun getArticles(){

    }
    fun addToFavorites(article: Article){

    }
}

class NewsViewModelFactory(private val repository: IRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(NewsViewModel::class.java))
            NewsViewModel(repository) as T else throw IllegalArgumentException("View Model Class Not Found !!!")
    }
}