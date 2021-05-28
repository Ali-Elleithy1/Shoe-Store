package com.example.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.databinding.FragmentWOnBoardingBinding


class WOnBoardingFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //findNavController().popBackStack()
        // Inflate the layout for this fragment
        val binding:FragmentWOnBoardingBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_w_on_boarding,container,false)
        binding.instructionsBTN.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_WOnBoardingFragment_to_IOnBoardingFragment))
        return binding.root
    }
}