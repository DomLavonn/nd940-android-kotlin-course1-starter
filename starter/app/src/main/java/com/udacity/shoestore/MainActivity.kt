package com.udacity.shoestore

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber
import androidx.databinding.DataBindingUtil
class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // assigning ID of the toolbar to a variable
       // val toolbar = findViewById<View>(R.id.toolbar) as Toolbar

        //
        setSupportActionBar(binding.toolbar);

        Timber.plant(Timber.DebugTree())

    }
}
