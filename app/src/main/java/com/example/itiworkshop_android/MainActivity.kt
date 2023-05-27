package com.example.itiworkshop_android


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.itiworkshop_android.data.model.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.toCollection
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private val TAG: String = "Exception"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val key = BuildConfig.API_KEY
        Log.i("TAG", "onCreate: $key")
        setContentView(R.layout.activity_main)

    }
}