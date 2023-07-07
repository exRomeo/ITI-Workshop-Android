package com.example.itiworkshop_android.features.home.news.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.itiworkshop_android.data.IRepository
import com.example.itiworkshop_android.data.Repository
import com.example.itiworkshop_android.data.model.Article
import com.example.itiworkshop_android.utility.NewsApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NewsViewModel(val repository: IRepository) : ViewModel() {
    private var _apiState: MutableStateFlow<NewsApiState> = MutableStateFlow(NewsApiState.Loading)
    val apiState = _apiState.asStateFlow()

    init {
        getArticles()
    }

    fun getArticles() {
        viewModelScope.launch {
            _apiState.value = repository.getAllNews()
        }
    }

    fun addToFavorites(article: Article) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertArticle(article)
        }
    }
}

class NewsViewModelFactory(private val repository: IRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(NewsViewModel::class.java))
            NewsViewModel(repository) as T else throw IllegalArgumentException("View Model Class Not Found !!!")
    }
}