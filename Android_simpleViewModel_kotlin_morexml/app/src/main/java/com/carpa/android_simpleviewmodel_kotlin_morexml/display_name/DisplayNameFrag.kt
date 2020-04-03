package com.carpa.android_simpleviewmodel_kotlin_morexml.display_name

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import com.carpa.android_simpleviewmodel_kotlin_morexml.R
import com.carpa.android_simpleviewmodel_kotlin_morexml.databinding.FragmentDisplayNameBinding

class DisplayNameFrag : Fragment() {

    private lateinit var viewModel: DisplayNameViewModel
    private lateinit var viewModelFactory: DisplayNameViewModelFactory
    private lateinit var binding: FragmentDisplayNameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_display_name, container, false)

        val name =
        if(arguments != null)
             DisplayNameFragArgs.fromBundle(arguments!!).nameVal
        else ""

        //In this case, it would be fine just to use bundle to pass one string that needs to be constant
        //and then to use OnSaved/RestoredIntsanceState, or another method.
        //I thought it was interesting to show how to create a viewModel able to have a constructor
        //with parameters.
        viewModelFactory = DisplayNameViewModelFactory(name)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DisplayNameViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel


        return binding.root
    }
}
