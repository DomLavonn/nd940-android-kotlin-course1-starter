package com.udacity.shoestore

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.adapters.MyAdapter
import com.udacity.shoestore.databinding.FragmentShoelistingBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoesViewModel
import java.io.PrintStream


class ShoelistingFragment : Fragment() {

    // Our view model
    private lateinit var viewModel: ShoesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
    }

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

        // Setting adapter
        binding.shoeList.adapter = MyAdapter(getContext() as Activity, viewModel.shoeList.value, inflater )

        // Floating button onclick
        binding.floatingAction.setOnClickListener{
            navigateFloatAction(it)
        }

        // menu
        setHasOptionsMenu(true)
        return binding.root
    }

    // Inflating my menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        // Inflates menu
        inflater?.inflate(R.menu.logout_menu, menu)
    }

    // Item selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

    // navigate to detail screen
    fun navigateFloatAction(view: View) {
        findNavController().navigate(R.id.action_shoelistingFragment_to_shoedetailFragment)
    }
}