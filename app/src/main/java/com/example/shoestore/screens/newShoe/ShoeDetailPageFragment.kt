package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.shoestore.databinding.FragmentShoeDetailPageBinding
import com.example.shoestore.models.Shoe
import com.example.shoestore.screens.shoeList.ShoeListViewModel

class ShoeDetailPageFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        // Inflate the layout for this fragment
        val binding:FragmentShoeDetailPageBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail_page,container,false)
        binding.addBTN.setOnClickListener { view ->
            //Toast.makeText(context, viewModel.shoe.value!!.name,Toast.LENGTH_LONG)
            viewModel.sendMessage("THE MESSAGE!")
            viewModel.addNewShoe(Shoe(binding.shoeNameET.text.toString(),binding.sizeET.text.toString().toDouble(),binding.brandET.text.toString(),binding.descriptionET.text.toString()))
            view.findNavController().navigate(ShoeDetailPageFragmentDirections.actionShoeDetailPageFragmentToShoeListingFragment(""))
        }

        return binding.root
    }

}