package com.udacity.shoestore.models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoesViewModel: ViewModel() {

    // Live data field
    var shoeList = MutableLiveData<ArrayList<Shoe>>()

    val shoes =  ArrayList<Shoe>()

    // let fragment know about the view model
    init {
        addShoes()
        shoeList.value = shoes
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ShoeViewModelClear", "removed")
    }

    fun addShoes() {
        shoes.add(Shoe("Retro 11s", 12.0, "Jordan", "Jordans iconic sneaker", mutableListOf("@drawable/nike")))
        shoes.add(Shoe("Retro 11s", 12.0, "Jordan", "Jordans iconic sneaker", mutableListOf("@drawable/nike")))
    }
}