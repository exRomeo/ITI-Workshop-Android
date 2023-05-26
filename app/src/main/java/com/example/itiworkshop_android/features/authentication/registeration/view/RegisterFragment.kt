package com.example.itiworkshop_android.features.authentication.registeration.view

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.example.itiworkshop_android.R
import com.example.itiworkshop_android.data.model.User
import com.example.itiworkshop_android.databinding.FragmentRegisterBinding
import com.example.itiworkshop_android.utility.CredentialsValidator
import com.example.itiworkshop_android.utility.constant.Constant


class RegisterFragment : Fragment() {
    lateinit var binding: FragmentRegisterBinding
    lateinit var user: User
    lateinit var credentialsValidator: CredentialsValidator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        credentialsValidator = CredentialsValidator.getInstance()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.registerBtn.setOnClickListener {
            if(checkUser())

                saveUser()
        }
//        user.name = binding.nameTextField.toString()
//        user.email = binding.emailTextField.toString()
//        user.password = binding.passwordTextField.toString()

    }

    fun checkUser() : Boolean {
         var isValidate = true

            if (binding.nameTextField.toString().isEmpty()) {
                binding.errorName.isVisible = true
                isValidate = false
            }

            if (binding.emailTextField.toString().isEmpty()) {
                binding.errorEmail.isVisible = true
                isValidate = false
            } else if (!credentialsValidator.isValidEmail(binding.emailTextField.toString())) {
                binding.errorEmail.text = getString(R.string.errorValidateEmail)
                binding.errorEmail.isVisible = true
                isValidate = false
            }

            if (binding.passwordTextField.toString().isEmpty()) {
                binding.errorPass.isVisible = true
                isValidate = false
            } else if (!credentialsValidator.isValidPassword(binding.passwordTextField.toString())) {
                binding.errorPass.text = getString(R.string.errorValidatePass)
                binding.errorPass.isVisible = true
                isValidate = false
            }

            if (binding.confirmPassTextField.toString().isEmpty()) {
                binding.errorConfirm.isVisible = true
                isValidate = false
            } else if (!binding.passwordTextField.toString()
                    .equals(binding.confirmPassTextField.toString())
            ) {
                binding.errorConfirm.text = getString(R.string.errorConfirmPass)
                binding.errorConfirm.isVisible = true
                isValidate = false
        }
        return isValidate
    }

    fun saveUser(){}
}