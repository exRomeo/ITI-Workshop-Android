package com.example.itiworkshop_android.features.authentication.login.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.itiworkshop_android.NewsApplication
import com.example.itiworkshop_android.R
import com.example.itiworkshop_android.data.model.auth.AuthenticationResponse
import com.example.itiworkshop_android.data.model.auth.LoginRequestBody
import com.example.itiworkshop_android.databinding.FragmentLoginBinding
import com.example.itiworkshop_android.features.authentication.AuthActivity
import com.example.itiworkshop_android.features.authentication.login.viewmodel.LoginViewModel
import com.example.itiworkshop_android.features.authentication.login.viewmodel.LoginViewModelFactory
import com.example.itiworkshop_android.features.home.HomeActivity
import kotlinx.coroutines.Dispatchers
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
            if (checkDataIsEntered()) {
                checkAuthentication(view)
                binding.errorMsgEmail.isVisible = false
                binding.errorPassword.isVisible = false
            }
        }
        binding.signupBtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.loginFragment_to_registerFragment)
        }
        lifecycleScope.launch(Dispatchers.Main) {
            loginViewModel.userState.collect { state ->
                when (state) {
                    is AuthenticationResponse.Loading -> {
                        println("LOADING !! ")
                    }

                    is AuthenticationResponse.Error -> {
                        print("ERROR")
                        binding.errorPassword.text = getString(R.string.incorrectEmailOrPassword)
                        binding.errorPassword.isVisible = true
                    }
                    else-> {
                        print("Success")
                        val intent = Intent(activity, HomeActivity::class.java)
                        startActivity(intent)
                        activity?.finish()
                    }
                }

            }
        }
    }

    private fun checkDataIsEntered(): Boolean {
        binding.errorMsgEmail.isVisible = false
        binding.errorPassword.isVisible = false
        var isEntered = true
        if (binding.emailTextField.text.toString().isEmpty()) {
            binding.errorMsgEmail.isVisible = true
            isEntered = false
        }
        if (binding.passTextField.text.toString().isEmpty()) {
            binding.errorPassword.isVisible = true
            isEntered = false
        }

        return isEntered

    }

    private fun checkAuthentication(view : View) {
        user = LoginRequestBody(
            binding.emailTextField.text.toString(),
            binding.passTextField.text.toString()
        )
        loginViewModel.checkUserAuthentication(user)

    }
}