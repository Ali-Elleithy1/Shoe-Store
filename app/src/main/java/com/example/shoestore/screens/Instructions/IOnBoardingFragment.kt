package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.shoestore.databinding.FragmentIOnBoardingBinding

class IOnBoardingFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentIOnBoardingBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_i_on_boarding,container,false)
        binding.shopBTN.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_IOnBoardingFragment_to_shoeListingFragment))

        return binding.root
    }
}