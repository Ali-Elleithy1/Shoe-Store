package com.example.shoestore.models

import android.os.Parcelable

data class Shoe(var name: String, var size: Double, var company: String, var description: String, var image:MutableList<String> = mutableListOf(""))