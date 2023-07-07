package com.example.itiworkshop_android.features.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.itiworkshop_android.R
import com.example.itiworkshop_android.databinding.ActivityAuthBinding
import com.example.itiworkshop_android.features.authentication.registeration.view.RegisterFragment
import com.google.android.material.navigation.NavigationView

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_auth)
        binding =  DataBindingUtil.setContentView(this,R.layout.activity_auth)



    }
}