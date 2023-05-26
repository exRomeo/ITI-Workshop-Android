package com.example.itiworkshop_android.features.authentication.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itiworkshop_android.data.IRepository
import com.example.itiworkshop_android.data.model.auth.AuthenticationResponse
import com.example.itiworkshop_android.data.model.auth.LoginRequestBody
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(val repository: IRepository) : ViewModel() {

    private var _userState: MutableStateFlow<AuthenticationResponse> =
        MutableStateFlow(AuthenticationResponse.Loading())
    val userState = _userState.asStateFlow()

    fun checkUserAuthentication(user: LoginRequestBody) {

        viewModelScope.launch {
            var response = repository.login(user)
            when (response) {
                is Throwable -> {
                    _userState.value = AuthenticationResponse.Error()
                }
                else -> {
                    _userState.value = response
                }
            }
        }
    }
}