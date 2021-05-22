package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding : FragmentLoginBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)

        binding.createBTN.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_WOnBoardingFragment))
        binding.loginBTN.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_WOnBoardingFragment))

        return binding.root
    }
}