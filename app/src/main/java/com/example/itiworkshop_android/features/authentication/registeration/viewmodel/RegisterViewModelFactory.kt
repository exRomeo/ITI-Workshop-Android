package com.example.itiworkshop_android.features.authentication.registeration.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.itiworkshop_android.data.IRepository

class RegisterViewModelFactory(private val authenticationRepository: IRepository) :
    ViewModelProvider.Factory{

    override fun <T: ViewModel> create(modelClass: Class<T>): T{
        return if(modelClass.isAssignableFrom(RegisterViewModel::class.java)){
            RegisterViewModel(authenticationRepository) as T
        }else{
            throw java.lang.IllegalArgumentException("ViewModel class is not found!")
        }
    }

}