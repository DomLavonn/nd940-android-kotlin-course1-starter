package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.databinding.FragmentOnboardingBinding
import com.udacity.shoestore.databinding.FragmentShoelistingBinding


class OnboardingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentOnboardingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_onboarding, container, false)

        return binding.root
    }


}