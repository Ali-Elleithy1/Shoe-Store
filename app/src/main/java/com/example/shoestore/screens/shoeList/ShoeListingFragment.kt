package com.example.shoestore

import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.util.Log
import android.view.*
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.databinding.CustomShoeBinding
import com.example.shoestore.databinding.FragmentShoeListingBinding
import com.example.shoestore.models.Shoe
import com.example.shoestore.screens.shoeList.ShoeListViewModel
import com.squareup.picasso.Picasso


class ShoeListingFragment : Fragment() {
    private val viewModel:ShoeListViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel: ShoeListViewModel by activityViewModels()
        //viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        // Inflate the layout for this fragment
        val binding:FragmentShoeListingBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_listing,container,false)
        val myLayout: LinearLayout = binding.myLayout
        myLayout.gravity = Gravity.CENTER_HORIZONTAL
        for (item in viewModel.shoeList)
        {
            //addNewShoe(item,myLayout)
            addNewCustomShoe(item,myLayout)
        }

        binding.floatingActionButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeListingFragment_to_shoeDetailPageFragment))
        setHasOptionsMenu(true)
        viewModel.shoe.observe(viewLifecycleOwner, Observer { newShoe ->
            viewModel.shoeList.add(newShoe)
            //addNewShoe(newShoe,myLayout)
            addNewCustomShoe(newShoe,myLayout)
        })


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,requireView().findNavController()) || super.onOptionsItemSelected(item)
    }
    private fun addNewCustomShoe(newShoe:Shoe, myLayout:LinearLayout)
    {
        //This function is for adding custom layout for the new shoe.
        val binding: CustomShoeBinding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.custom_shoe,myLayout,false)
            //LayoutInflater.from(context).inflate(R.layout.custom_shoe, myLayout, false)
        binding.customNameTV.text = newShoe.name
        binding.customSizeTV.text = newShoe.size.toString()
        binding.customDescriptionTV.text = newShoe.description
        binding.customIV.setImageResource(R.drawable.ic_launcher_background)
        if(newShoe.image[0].isNotEmpty()) {
            Picasso.get().load(newShoe.image?.get(0)).into(binding.customIV)
        }
        myLayout.addView(binding.root)
    }
    private fun addNewShoe(newShoe:Shoe, myLayout:LinearLayout)
    {
        //This function is for adding every view separately, but I am not using it.

        //Adding new ImageView to the layout
        val shoeIV = ImageView(context)
        shoeIV.setImageResource(R.drawable.ic_launcher_background)
        if(newShoe.image[0].isNotEmpty()) {
            Picasso.get().load(newShoe.image?.get(0)).into(shoeIV)
        }
        shoeIV.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        myLayout.addView(shoeIV)

        //Adding new TextView for the shoe name to the layout
        val nameTV = TextView(context)
        var str = SpannableStringBuilder("Name: "+newShoe.name)
        str.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            6,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        nameTV.text = str
        nameTV.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        myLayout.addView(nameTV)

        //Adding new TextView for the shoe Size to the layout
        val sizeTV = TextView(context)
        str = SpannableStringBuilder("Size: "+newShoe.size.toString())
        str.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            6,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        sizeTV.text = str
        sizeTV.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        myLayout.addView(sizeTV)

        //Adding new TextView for the shoe description to the layout
        val descriptionTV = TextView(context)
        str = SpannableStringBuilder("Description: "+newShoe.description)
        str.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            13,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        descriptionTV.text = str
        descriptionTV.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        myLayout.addView(descriptionTV)
    }
}
