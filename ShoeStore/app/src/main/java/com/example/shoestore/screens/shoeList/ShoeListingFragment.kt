package com.example.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.databinding.FragmentShoeListingBinding
import com.example.shoestore.models.Shoe
import com.example.shoestore.screens.shoeList.ShoeListAdapter
import com.example.shoestore.screens.shoeList.ShoeListViewModel

class ShoeListingFragment : Fragment() {
    private lateinit var viewModel:ShoeListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        // Inflate the layout for this fragment
        val binding:FragmentShoeListingBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_listing,container,false)
        var adapter:ShoeListAdapter = context?.let { ShoeListAdapter(it,viewModel.shoeList) }!!
        val args: ShoeListingFragmentArgs by navArgs()
        if(args.name!="null") {
            viewModel.shoeList.add(
                Shoe(
                    args.name,
                    args.size.toDouble(),
                    args.brand,
                    args.description
                )
            )
        }
        binding.shoeLV.adapter=adapter
        binding.floatingActionButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeListingFragment_to_shoeDetailPageFragment))
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController()) || super.onOptionsItemSelected(item)
    }
}