package com.example.itiworkshop_android.features.home.news.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible

import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.itiworkshop_android.NewsApplication
import com.example.itiworkshop_android.R
import com.example.itiworkshop_android.data.IRepository
import com.example.itiworkshop_android.data.model.Article
import com.example.itiworkshop_android.databinding.FragmentNewsBinding
import com.example.itiworkshop_android.features.home.news.viewmodel.NewsViewModel
import com.example.itiworkshop_android.features.home.news.viewmodel.NewsViewModelFactory
import com.example.itiworkshop_android.utility.NewsApiState
import com.facebook.shimmer.ShimmerFrameLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding
    private lateinit var shimmerFrameLayout: ShimmerFrameLayout

    private val repository: IRepository by lazy {
        (requireContext().applicationContext as NewsApplication).repository
    }
    private val viewModel: NewsViewModel by lazy {
        ViewModelProvider(
            this.requireActivity(),
            NewsViewModelFactory(repository)
        )[NewsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)
        shimmerFrameLayout = binding.shimmer
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.adapter = ArticlesAdapter("🤍") {
            viewModel.addToFavorites(it)
        }

        lifecycleScope.launchWhenCreated {
            viewModel.apiState.collect {
                updateUI(it)
            }
        }

    }

    private fun updateUI(state: NewsApiState) {
        when (state) {
            is NewsApiState.Loading -> {
                Log.i("TAG", "updateUI: Loading State")
                showLoading()
            }

            is NewsApiState.Success -> {
                Log.i("TAG", "updateUI: Success State")
                showNews(state.articles)
            }

            is NewsApiState.Failure -> {
                Log.i("TAG", "updateUI: Failure State")
                showError(state.message)
            }
        }
    }


    private fun showNews(articles: List<Article>) {
        Log.i("TAG", "showNews: ${articles.size}")
        shimmerFrameLayout.stopShimmer()
        shimmerFrameLayout.visibility = View.GONE
        binding.articlesTitle.visibility = View.VISIBLE
        binding.articlesList.visibility = View.VISIBLE

        binding.adapter!!.submitList(articles)
    }

    private fun showLoading() {
        shimmerFrameLayout.startShimmer()

    }

    private fun showError(exception: Exception) {

    }

}