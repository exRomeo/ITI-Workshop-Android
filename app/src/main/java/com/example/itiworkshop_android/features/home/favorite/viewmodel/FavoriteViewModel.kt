package com.example.itiworkshop_android.features.home.favorite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.itiworkshop_android.data.IRepository
import com.example.itiworkshop_android.data.Repository
import com.example.itiworkshop_android.data.model.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf

class FavoriteViewModel(repository: IRepository) : ViewModel() {

    private var _favoriteList: MutableStateFlow<List<Article>> = MutableStateFlow(listOf())
    val favoriteList = _favoriteList.asStateFlow()

    init {
        getFavoriteArticles()
    }
    fun getFavoriteArticles() {


    }

    fun removeArticleFromFavorites(article: Article) {

    }
}

class FavoriteViewModelFactory(private val repository: IRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(FavoriteViewModel::class.java))
            FavoriteViewModel(repository) as T else throw IllegalArgumentException("View Model Class Not Found !!!")
    }
}