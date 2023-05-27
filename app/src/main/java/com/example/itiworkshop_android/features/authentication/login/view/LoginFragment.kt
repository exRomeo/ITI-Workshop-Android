package com.example.itiworkshop_android.features.authentication.login.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.itiworkshop_android.NewsApplication
import com.example.itiworkshop_android.R
import com.example.itiworkshop_android.data.model.User
import com.example.itiworkshop_android.data.model.auth.AuthenticationResponse
import com.example.itiworkshop_android.data.model.auth.LoginRequestBody
import com.example.itiworkshop_android.databinding.FragmentLoginBinding
import com.example.itiworkshop_android.features.authentication.login.viewmodel.LoginViewModel
import com.example.itiworkshop_android.features.authentication.login.viewmodel.LoginViewModelFactory
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    lateinit var user: LoginRequestBody
    lateinit var loginViewModel: LoginViewModel
    lateinit var loginViewModelFactory: LoginViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        loginViewModelFactory =
            LoginViewModelFactory((context?.applicationContext as NewsApplication).repository)
        loginViewModel =
            ViewModelProvider(this, loginViewModelFactory).get(LoginViewModel::class.java)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginBtn.setOnClickListener {
            if (checkUser()) {
                user = LoginRequestBody(
                    binding.emailTextField.text.toString(),
                    binding.passTextField.text.toString()
                )
                Log.i("Exception", "${user.email}\n${user.password}")
                loginViewModel.checkUserAuthentication(user)
                lifecycleScope.launch {
                    loginViewModel.userState.collect { state ->
                        when (state) {
                            is AuthenticationResponse.LoginResponseBody -> {
//                                Navigation.findNavController(view)
//                                    .navigate(R.id.action_loginFragment_to_homeFragment)
                            }
                            is AuthenticationResponse.Loading -> {
                                println("LOADING !! ")
                            }
                            is AuthenticationResponse.Error -> {
                                println("ERROR !!")
                            }

                        }

                    }
                }

            }
        }
        binding.signupBtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.loginFragment_to_registerFragment)
        }

    }

    fun checkUser(): Boolean {
        binding.errorMsgEmail.isVisible = false
        binding.errorPassword.isVisible = false
        var isValidate = true
        if (binding.emailTextField.toString().isEmpty()) {
            binding.errorMsgEmail.isVisible = true
            isValidate = false
        }
        if (binding.passTextField.toString().isEmpty()) {
            binding.errorPassword.isVisible = true
            isValidate = false
        }

        return isValidate

    }
}