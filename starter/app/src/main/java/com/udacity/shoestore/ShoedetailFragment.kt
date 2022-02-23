package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.adapters.MyAdapter
import com.udacity.shoestore.databinding.FragmentShoedetailBinding
import com.udacity.shoestore.databinding.FragmentShoelistingBinding
import kotlinx.android.synthetic.main.fragment_shoedetail.*
import com.udacity.shoestore.models.Shoe

class ShoedetailFragment : Fragment() {

    private val shoe = Shoe("", 0.0,"", "" )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoedetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoedetail, container, false)


        // Set value from layout file
        binding.shoe = shoe



        // Navigate back to listing
        binding.buttonCancel.setOnClickListener{
            findNavController().navigate(R.id.action_shoedetailFragment_to_shoelistingFragment)
        }

        binding.buttonSave.setOnClickListener {

            // Setting with data
            shoe?.name = input_name.text.toString()
            shoe?.company = input_company.text.toString()
            shoe?.description = input_desc.text.toString()
            shoe?.size = input_size.text.toString().toDouble()
        }

        return binding.root
    }


}