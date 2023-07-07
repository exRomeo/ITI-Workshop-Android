package com.example.itiworkshop_android.features.authentication.registeration.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itiworkshop_android.data.IRepository
import com.example.itiworkshop_android.data.model.auth.AuthenticationResponse
import com.example.itiworkshop_android.data.model.auth.RegistrationRequestBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RegisterViewModel(
    val authenticationRepository: IRepository
) : ViewModel() {

    private val _mutableStateFlow: MutableStateFlow<AuthenticationResponse> =
        MutableStateFlow(AuthenticationResponse.Loading())

    val stateFlow: StateFlow<AuthenticationResponse> = _mutableStateFlow.asStateFlow()

    fun register(registerationRequestBody: RegistrationRequestBody){
        val response = AuthenticationResponse.LoginResponseBody(
            "",
            registerationRequestBody.email,
            registerationRequestBody.displayName
        )
        authenticationRepository.saveUserData(response)
       viewModelScope.launch(Dispatchers.IO) {
           val authenticationResponse = authenticationRepository.register(registerationRequestBody)
           _mutableStateFlow.value = authenticationResponse
       }
    }
}