package com.example.itiworkshop_android.features.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.itiworkshop_android.R
import com.example.itiworkshop_android.databinding.ActivityAuthBinding
import com.example.itiworkshop_android.features.authentication.registeration.view.RegisterFragment

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    private val fragmentManager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        binding =  DataBindingUtil.setContentView(this,R.layout.activity_auth)
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainerView, RegisterFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}