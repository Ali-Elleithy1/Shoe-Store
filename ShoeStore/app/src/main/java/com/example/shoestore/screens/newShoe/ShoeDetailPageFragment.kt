package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.shoestore.databinding.FragmentShoeDetailPageBinding

class ShoeDetailPageFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentShoeDetailPageBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail_page,container,false)
        binding.addBTN.setOnClickListener { view ->
            view.findNavController().navigate(ShoeDetailPageFragmentDirections.actionShoeDetailPageFragmentToShoeListingFragment(binding.shoeNameET.text.toString(),
                                                                                                                                binding.sizeET.text.toString(),
                                                                                                                                binding.brandET.text.toString(),
                                                                                                                                binding.descriptionET.text.toString()))
        }

        return binding.root
    }

}