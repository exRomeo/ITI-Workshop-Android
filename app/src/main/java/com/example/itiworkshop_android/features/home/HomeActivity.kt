package com.example.itiworkshop_android.features.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.itiworkshop_android.NewsApplication
import com.example.itiworkshop_android.R
import com.example.itiworkshop_android.utility.NewsApiState
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val repository = (applicationContext?.applicationContext as NewsApplication).repository
        lifecycleScope.launch {
            val response = repository.getAllNews()
            when (response) {
                is NewsApiState.Success -> {
                    Log.i("TAG", "onCreate: ${response.articles}")
                }

                else -> {
                    Log.i("TAG", "onCreate: error $response")
                }
            }
        }

    }
}