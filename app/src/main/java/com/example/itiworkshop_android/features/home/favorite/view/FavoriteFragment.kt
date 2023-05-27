package com.example.itiworkshop_android.features.home.favorite.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.itiworkshop_android.NewsApplication
import com.example.itiworkshop_android.R
import com.example.itiworkshop_android.data.IRepository
import com.example.itiworkshop_android.databinding.FragmentFavoriteBinding
import com.example.itiworkshop_android.features.home.favorite.viewmodel.FavoriteViewModel
import com.example.itiworkshop_android.features.home.favorite.viewmodel.FavoriteViewModelFactory
import com.example.itiworkshop_android.features.home.news.view.ArticlesAdapter
import kotlinx.coroutines.flow.collect


class FavoriteFragment : Fragment() {
    private val repository: IRepository by lazy {
        (requireContext().applicationContext as NewsApplication).repository
    }
    val viewModel: FavoriteViewModel by lazy {
        ViewModelProvider(
            this.requireActivity(),
            FavoriteViewModelFactory(repository)
        )[FavoriteViewModel::class.java]
    }
    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorite, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.adapter = ArticlesAdapter("❤") {
            viewModel.removeArticleFromFavorites(it)
        }

        lifecycleScope.launchWhenStarted {
            viewModel.favoriteList.collect {
                binding.adapter!!.submitList(it)
            }
        }
    }


}