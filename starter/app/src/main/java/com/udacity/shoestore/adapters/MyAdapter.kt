package com.udacity.shoestore.adapters

import android.app.Activity
import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoelistingFragment
import com.udacity.shoestore.models.Shoe
import org.w3c.dom.Text
import java.security.AccessController.getContext

class MyAdapter(private val context: Activity, private val arrayList: ArrayList<Shoe>?, private val inflater: LayoutInflater) :
    ArrayAdapter<Shoe>(context, android.R.layout.simple_list_item_1, arrayList!!) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view: View = inflater.inflate(R.layout.shoe_item, null)

        val name: TextView  = view.findViewById(R.id.shoe_name)
        val size: TextView = view.findViewById(R.id.shoe_size)
        val company: TextView = view.findViewById(R.id.shoe_company)
        val desc : TextView = view.findViewById(R.id.shoe_desc)
        val imageView: ImageView  = view.findViewById(R.id.shoe_img)

        // Set the data to the position
        name.text = arrayList?.get(position)?.name ?: "none"
        size.text =  arrayList?.get(position)?.size.toString()
        company.text = arrayList?.get(position)?.company ?: "none"
        desc.text = arrayList?.get(position)?.description

        val context = imageView.context
        val id = context.resources.getIdentifier("nike", "drawable", context.packageName)
        imageView.setImageResource(id)

        return view
    }
}