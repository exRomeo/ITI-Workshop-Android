package com.example.itiworkshop_android.features.authentication.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itiworkshop_android.data.IRepository
import com.example.itiworkshop_android.data.model.auth.AuthenticationResponse
import com.example.itiworkshop_android.data.model.auth.LoginRequestBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: IRepository) : ViewModel() {

    private var _userState: MutableStateFlow<AuthenticationResponse> =
        MutableStateFlow(AuthenticationResponse.Loading())
    val userState :StateFlow<AuthenticationResponse> = _userState

    fun checkUserAuthentication(user: LoginRequestBody) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.login(user)
            _userState.value = response
        }
    }
}