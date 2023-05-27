package com.example.itiworkshop_android.features.home.news.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.itiworkshop_android.NewsApplication
import com.example.itiworkshop_android.R
import com.example.itiworkshop_android.data.IRepository
import com.example.itiworkshop_android.data.Repository
import com.example.itiworkshop_android.databinding.FragmentNewsBinding
import com.example.itiworkshop_android.features.home.news.viewmodel.NewsViewModel
import com.example.itiworkshop_android.features.home.news.viewmodel.NewsViewModelFactory


class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding
    private lateinit var adapter: ArticlesAdapter
    private val repository: IRepository by lazy {
        (requireContext().applicationContext as NewsApplication).repository
    }
    private val viewModel: NewsViewModel by lazy {
        ViewModelProvider(
            this.requireActivity(),
            NewsViewModelFactory(repository)
        )[NewsViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ArticlesAdapter("🤍") {
            viewModel.addToFavorites(it)
        }
        binding.articlesList.adapter = adapter

        lifecycleScope.launchWhenCreated {
            viewModel.articleList.collect() {
                adapter.submitList(it)
            }
        }

    }


}