package com.example.shoestore.screens.shoeList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.models.Shoe

class ShoeListViewModel : ViewModel()
{
  lateinit var shoeList:MutableList<Shoe>
  private val _shoe = MutableLiveData<Shoe>()
          val shoe:LiveData<Shoe>
          get() = _shoe


  init {
      reset()
  }

  private fun reset()
  {
    shoeList = mutableListOf(Shoe(
      "Reebok Men's Nano 9 Cross Trainer", 11.0, "Reebok", "CrossFitters informed the design of these men's CrossFit shoes. " +
                                                                                                                   "A woven textile upper gives a locked-in feel. The support cage adds stability for lifting weights. " +
                                                                                                                   "Cushioning provides responsive comfort for run-intense WODs. ",
                                                                                                                    mutableListOf("https://images-na.ssl-images-amazon.com/images/I/81uR%2B3HxpkL._AC_UX395_.jpg")
    ),
    Shoe("Adidas Men's Daily 3.0 Skate Shoe", 12.0, "Adidas", "Adidas male daily 3.0 shoes.",mutableListOf("https://cdn.deporvillage.com/cdn-cgi/image/w=900,dpr=1,f=auto,q=75,fit=contain,background=white/product/ad-fw7033_001.jpg")))
  }

  fun addNewShoe(newShoe:Shoe)
  {
      _shoe.value = newShoe
  }
}

