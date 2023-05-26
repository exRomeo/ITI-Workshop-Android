package com.example.itiworkshop_android.features.authentication.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itiworkshop_android.data.IRepository
import com.example.itiworkshop_android.data.model.auth.LoginRequestBody
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(val repository : IRepository):ViewModel() {

//
//    private var userState: MutableStateFlow<AuthenticationResponse> = MutableStateFlow()


    fun checkUserAuthentication(user: LoginRequestBody){
        viewModelScope.launch {
//           userState = RetrofitAuthenticationHelper.getRetrofitAuthenticationService().login(user)

        }
    }
}