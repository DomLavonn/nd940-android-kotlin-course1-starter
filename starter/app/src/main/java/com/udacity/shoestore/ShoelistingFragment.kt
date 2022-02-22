package com.udacity.shoestore

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.FragmentShoelistingBinding
import com.udacity.shoestore.models.ShoesViewModel
import java.io.PrintStream


class ShoelistingFragment : Fragment() {


    // Our view model
    private lateinit var viewModel: ShoesViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoelistingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoelisting, container, false)


        // Takes fragment and viewmodel class we want
        // Creates new instance of shoeviewmodel for me
        viewModel = ViewModelProvider(this).get(ShoesViewModel::class.java)

        //Observer
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { newItem ->

        print("sfdsaadsfsadfdsafasdfdsafsdafsdfsdafdasfjklsdalfkasdkfsdalfksdafjsdafsdajffjlkasd")
        } )


        return binding.root
    }


}