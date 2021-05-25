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
        val viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
        // Inflate the layout for this fragment
        val binding:FragmentShoeDetailPageBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail_page,container,false)
        binding.addBTN.setOnClickListener { view ->
            if(binding.shoeNameET.text.isNotEmpty() && binding.brandET.text.isNotEmpty() && binding.sizeET.text.isNotEmpty() && binding.descriptionET.text.isNotEmpty()) {
                viewModel.addNewShoe(
                    Shoe(
                        binding.shoeNameET.text.toString(),
                        binding.sizeET.text.toString().toDouble(),
                        binding.brandET.text.toString(),
                        binding.descriptionET.text.toString()
                    )
                )
                view.findNavController()
                    .navigate(ShoeDetailPageFragmentDirections.actionShoeDetailPageFragmentToShoeListingFragment())
            }
            else
            {
                Toast.makeText(context,"Please fill all the fields.",Toast.LENGTH_LONG).show()
            }
        }
        binding.cancelBTN.setOnClickListener { view ->
            view.findNavController().navigate(ShoeDetailPageFragmentDirections.actionShoeDetailPageFragmentToShoeListingFragment())
        }
        return binding.root
    }

}
