package com.example.itiworkshop_android.features.home.news.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.itiworkshop_android.R
import com.example.itiworkshop_android.data.model.Article
import com.example.itiworkshop_android.databinding.NewsCellBinding

class ArticlesAdapter(
    private val favoriteButtonIcon: String,
    private val onClick: (Article) -> Unit
) : ListAdapter<Article, ArticlesAdapter.ViewHolder>(ArticlesDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: NewsCellBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.news_cell,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        Log.i("TAG", "onBindViewHolder: ${item.content}")
        Glide.with(holder.binding.root).load(item.urlToImage)
            .placeholder(R.drawable.img_placeholder).into(holder.binding.articleImage)
        holder.binding.articleTitle.text = item.title
        holder.binding.articleDescription.text = item.description
        holder.binding.cellButton.text = favoriteButtonIcon
        holder.binding.cellButton.setOnClickListener { onClick(item) }
    }

    inner class ViewHolder(var binding: NewsCellBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}

class ArticlesDiffUtil : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean =
        oldItem.url == newItem.url


    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean =
        oldItem == newItem


}