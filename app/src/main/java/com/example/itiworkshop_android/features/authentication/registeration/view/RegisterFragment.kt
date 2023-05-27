package com.example.itiworkshop_android.features.authentication.registeration.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.itiworkshop_android.NewsApplication

import androidx.navigation.Navigation
import com.example.itiworkshop_android.R
import com.example.itiworkshop_android.data.IRepository
import com.example.itiworkshop_android.data.model.User
import com.example.itiworkshop_android.data.model.auth.RegistrationRequestBody
import com.example.itiworkshop_android.databinding.FragmentRegisterBinding
import com.example.itiworkshop_android.features.authentication.registeration.viewmodel.RegisterViewModel
import com.example.itiworkshop_android.features.authentication.registeration.viewmodel.RegisterViewModelFactory
import com.example.itiworkshop_android.utility.CredentialsValidator

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    lateinit var user: User
    lateinit var credentialsValidator: CredentialsValidator
    private val registerViewModel: RegisterViewModel by lazy{
        val repo: IRepository = (context?.applicationContext as NewsApplication).repository
        val factory = RegisterViewModelFactory(repo)
        ViewModelProvider(this,factory)[RegisterViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        credentialsValidator = CredentialsValidator
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.registerBtn.setOnClickListener {
            binding.errorName.isVisible = false
            binding.errorPass.isVisible = false
            binding.errorEmail.isVisible = false
            binding.errorConfirm.isVisible = false
            if (checkUser())

                saveUser(RegistrationRequestBody(
                    binding.emailTextField.text.toString(),
                    binding.passwordTextField.text.toString(),
                    binding.nameTextField.text.toString()
                ))
        }
        binding.backBtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.registerFragment_to_loginFragment)
        }
//        user.name = binding.nameTextField.toString()
//        user.email = binding.emailTextField.toString()
//        user.password = binding.passwordTextField.toString()

    }

    fun checkUser(): Boolean {
        var isValidate = true

        if (binding.nameTextField.text.toString().isEmpty()) {
            binding.errorName.isVisible = true
            isValidate = false
        }

        if (binding.emailTextField.text.toString().isEmpty()) {
            binding.errorEmail.isVisible = true
            isValidate = false
        } else if (!credentialsValidator.isValidEmail(binding.emailTextField.text.toString())) {
            binding.errorEmail.text = getString(R.string.errorValidateEmail)
            binding.errorEmail.isVisible = true
            isValidate = false
        }

        if (binding.passwordTextField.text.toString().isEmpty()) {
            binding.errorPass.isVisible = true
            isValidate = false
        } else if (!credentialsValidator.isValidPassword(binding.passwordTextField.text.toString())) {
            binding.errorPass.text = getString(R.string.errorValidatePass)
            binding.errorPass.isVisible = true
            isValidate = false
        }

        if (binding.confirmPassTextField.text.toString().isEmpty()) {
            binding.errorConfirm.isVisible = true
            isValidate = false
        } else if (!binding.passwordTextField.text.toString()
                .equals(binding.confirmPassTextField.text.toString())
        ) {
            binding.errorConfirm.text = getString(R.string.errorConfirmPass)
            binding.errorConfirm.isVisible = true
            isValidate = false
        }
        return isValidate
    }

    fun saveUser(body: RegistrationRequestBody) {
        registerViewModel.register(body)
    }
}