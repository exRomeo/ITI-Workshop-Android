package com.example.itiworkshop_android.features.authentication.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.example.itiworkshop_android.R
import com.example.itiworkshop_android.data.model.User
import com.example.itiworkshop_android.databinding.FragmentLoginBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class LoginFragment : Fragment() {

    lateinit var binding : FragmentLoginBinding
    lateinit var user: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginBtn.setOnClickListener {
            binding.errorMsgEmail.isVisible = false
            binding.errorPassword.isVisible = false
            checkUser()
        }
    }
    fun checkUser(){
        if(binding.emailTextField.toString().isEmpty() || binding.passTextField.toString().isEmpty()) {
            if (binding.emailTextField.toString().isEmpty())
                binding.errorMsgEmail.isVisible = true
            if (binding.passTextField.toString().isEmpty())
                binding.errorPassword.isVisible = true
        }
      else{
          //Check Email, password
        }

    }
}