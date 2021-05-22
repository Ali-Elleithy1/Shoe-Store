package com.example.shoestore.screens.shoeList

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.shoestore.R
import com.example.shoestore.ShoeListingFragment
import com.example.shoestore.databinding.CustomShoeBinding
import com.example.shoestore.models.Shoe
import com.squareup.picasso.Picasso

class ShoeListAdapter(context: Context, objects: MutableList<Shoe>) :
    ArrayAdapter<Shoe>(context, 0, objects) {
    private lateinit var inflater:LayoutInflater
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding:CustomShoeBinding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.custom_shoe,parent,false)
        if(getItem(position)?.image?.get(0)!!.length > 1) {
            Log.i("URL", getItem(position)?.image.toString())
            Picasso.get().load(getItem(position)?.image?.get(0)).into(binding.customIV)
        }
        binding.customNameTV.text = "Name: "+getItem(position)?.name
        binding.customSizeTV.text = "Size: "+getItem(position)?.size.toString()
        binding.customDescriptionTV.text = "Description: "+getItem(position)?.description
        return binding.root
    }
}