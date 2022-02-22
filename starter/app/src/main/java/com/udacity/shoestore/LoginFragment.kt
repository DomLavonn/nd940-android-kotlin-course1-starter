package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false )

        // Setting onclick listener to nav to Welcome
        binding.buttonLogin.setOnClickListener{

            // Navigation to welcome fragment
            findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }

        binding.buttonSignup.setOnClickListener{
            // Navigation to welcome fragment
            findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
        return binding.root
    }


}