package com.example.itiworkshop_android.features.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.itiworkshop_android.databinding.ActivityHomeBinding
import com.google.android.material.navigation.NavigationView

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