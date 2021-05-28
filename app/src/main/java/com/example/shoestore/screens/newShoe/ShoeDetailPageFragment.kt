package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.FragmentShoeDetailPageBinding
import com.example.shoestore.models.Shoe
import com.example.shoestore.screens.shoeList.ShoeListViewModel

class ShoeDetailPageFragment : Fragment() {
    private val shoe:Shoe = Shoe("",0.0,"","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel: ShoeListViewModel by activityViewModels()
        //val viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
        // Inflate the layout for this fragment
        val binding:FragmentShoeDetailPageBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail_page,container,false)
        binding.shoe = shoe
        binding.addBTN.setOnClickListener { view ->
            if(binding.shoeNameET.text.isNotEmpty() && binding.brandET.text.isNotEmpty() && binding.sizeET.text.isNotEmpty() && binding.descriptionET.text.isNotEmpty()) {
                binding.shoe?.name = binding.shoeNameET.text.toString()
                binding.shoe?.size = binding.sizeET.text.toString().toDouble()
                binding.shoe?.company = binding.brandET.text.toString()
                binding.shoe?.description = binding.descriptionET.text.toString()
                viewModel.addNewShoe(
                    shoe
                )
                findNavController().navigateUp()
            }
            else
            {
                Toast.makeText(context,"Please fill all the fields.",Toast.LENGTH_LONG).show()
            }
        }
        binding.cancelBTN.setOnClickListener { view ->
            findNavController().navigateUp()
        }
        return binding.root
    }

}