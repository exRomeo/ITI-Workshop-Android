package com.example.itiworkshop_android


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.itiworkshop_android.data.model.Article
import com.example.itiworkshop_android.data.model.Source
import com.example.itiworkshop_android.data.model.auth.AuthenticationResponse
import com.example.itiworkshop_android.features.authentication.AuthActivity
import com.example.itiworkshop_android.features.home.HomeActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private val TAG: String = "Exception"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val key = BuildConfig.API_KEY
        setContentView(R.layout.activity_main)

        val repo = (application as NewsApplication).repository
        val isLoggedIn = repo.readUserData()
        if(isLoggedIn is AuthenticationResponse.Error){
            Log.i(TAG, "Not cached")
            startActivity(Intent(this,AuthActivity::class.java))
            finish()
        }
        else{
            startActivity(Intent(this,HomeActivity::class.java))
            Log.i(TAG, "cached")
            finish()
        }

    }
}