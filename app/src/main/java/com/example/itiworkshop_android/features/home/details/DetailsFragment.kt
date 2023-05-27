package com.example.itiworkshop_android.features.home.details

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.itiworkshop_android.R
import com.example.itiworkshop_android.data.model.Article
import com.example.itiworkshop_android.data.model.Source
import com.example.itiworkshop_android.databinding.FragmentDetailsBinding
import com.example.itiworkshop_android.utility.Constant
import com.example.itiworkshop_android.utility.CredentialsValidator

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_details,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUiData()
    }
    private fun initUiData(){
        val article = arguments?.get(Constant.ARTICLE_SAFE_ARGS_KEY) as Article
      //  val bitmap = CredentialsValidator.getBitmapFromByteArray(article.imageAsByteArray)
        //binding.ivArticleImage.setImageBitmap(CredentialsValidator.getBitmapFromByteArray(article.imageAsByteArray))
        binding.tvArticleAuthor.text = article.author
        binding.tvArticleleDate.text = article.publishedAt
        binding.tvArticleTitle.text = article.title
        binding.tvArticleContent.text = article.content
    }
}