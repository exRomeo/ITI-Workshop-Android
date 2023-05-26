package com.example.itiworkshop_android.features.authentication.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.itiworkshop_android.data.IRepository

class LoginViewModelFactory(val repository :IRepository) :  ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            LoginViewModel(repository) as T
        } else {
            throw IllegalArgumentException("viewModel class isn't found")
        }
    }
}