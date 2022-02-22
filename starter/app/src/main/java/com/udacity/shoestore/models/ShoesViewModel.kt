package com.udacity.shoestore.models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoesViewModel: ViewModel() {

    // Live data field
    var shoeList = MutableLiveData<MutableList<Shoe>>()

    var shoes: MutableList<Shoe> =  mutableListOf( Shoe("Retro 11s", 12.0, "Jordan", "Jordans iconic sneaker", mutableListOf("@drawable/nike")))
    // let fragment know about the view model
    init {
        shoeList.value = shoes
    }



    override fun onCleared() {
        super.onCleared()
        Log.i("ShoeViewModelClear", "removed")
    }
}