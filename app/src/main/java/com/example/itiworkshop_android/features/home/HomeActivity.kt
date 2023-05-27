package com.example.itiworkshop_android.features.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.itiworkshop_android.R
import com.example.itiworkshop_android.databinding.ActivityHomeBinding
import com.google.android.material.navigation.NavigationView
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.itiworkshop_android.NewsApplication
import com.example.itiworkshop_android.R
import com.example.itiworkshop_android.utility.NewsApiState
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        supportActionBar?.hide()
        drawerLayout = binding.drawerLayout
        navView = binding.sideDrawer
        navController = Navigation.findNavController(this,R.id.home_content_nav_host)
        navView.setupWithNavController(navController)
        binding.drawerButton.setOnClickListener{
            drawerLayout.openDrawer(GravityCompat.START)
        }

    }

}