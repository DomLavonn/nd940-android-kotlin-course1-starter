package com.udacity.shoestore

import android.app.Activity
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
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


class ShoelistingFragment : Fragment() {

    // Our view model
    private lateinit var viewModel: ShoesViewModel

    var testArr: ArrayList<Shoe>? = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: FragmentShoelistingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoelisting, container, false)

        // Takes fragment and viewmodel class we want
        // Creates new instance of shoeviewmodel for me
        viewModel = ViewModelProvider(this).get(ShoesViewModel::class.java)

      //  var testArr: ArrayList<Shoe>? = arrayListOf()



        // Setting adapter
        binding.shoeList.adapter = MyAdapter(getContext() as Activity, testArr, inflater )

        // Getting passed args
        var args = ShoelistingFragmentArgs.fromBundle(requireArguments())

        // grabbing args from bundle
        if ( args.company == null || args.name == null || args.description == null || args.size == null) {
            Toast.makeText(requireContext(), args.name, Toast.LENGTH_LONG).show()

        }else{
            if(args.name != "" && args.company != "" && args.size != 0.0.toFloat() &&  args.description != ""  ) {
                testArr =   viewModel.shoeList.value


                //  Toast.makeText(requireContext(), "Data changes", Toast.LENGTH_LONG).show()
                viewModel.shoeList.value?.add(Shoe(args.name, args.size.toDouble(), args.company, args.description))

                //Observer
                viewModel.shoeList.observe(viewLifecycleOwner, Observer { newItem ->
                   // binding.addme.addView(newItem[newItem.size-1])
                    binding.shoeList.deferNotifyDataSetChanged()




                  //  addToList(inflater, args.name, args.size.toDouble(), args.company, args.description)
                    // LinearLayout =

                    // testArr?.add(newItem[newItem.size - 1])
                    //   MyAdapter(getContext() as Activity, testArr, inflater ).notifyDataSetChanged()


                    Toast.makeText(requireContext(), newItem.toString(), Toast.LENGTH_LONG).show()
                    //viewModel.shoeList.value.size
                } )
                // Setting adapter


            }

        }




        // Floating button onclick
        binding.floatingAction.setOnClickListener{
            navigateFloatAction(it)
        }

        // menu
        setHasOptionsMenu(true)


     //  Toast.makeText(requireContext(), args.name, Toast.LENGTH_LONG).show()

        return binding.root
    }

    fun addToList(inflater: LayoutInflater, name: String, size: Double, company:String, description:String)
    {

        viewModel.shoeList.value?.add(Shoe(name, size, company, description))
      //  viewModel.shoeList.value = testArr
        //ad.notifyDataSetChanged()
        //Toast.makeText(requireContext(), viewModel.shoeList.value?.size, Toast.LENGTH_LONG).show()

        //adapter.adapter.notifyDataSetChanged()
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