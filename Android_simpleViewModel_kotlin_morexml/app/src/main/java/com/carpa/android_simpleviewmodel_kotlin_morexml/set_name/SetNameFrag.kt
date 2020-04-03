package com.carpa.android_simpleviewmodel_kotlin_morexml.set_name

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation

import com.carpa.android_simpleviewmodel_kotlin_morexml.R
import com.carpa.android_simpleviewmodel_kotlin_morexml.databinding.FragmentSetNameBinding

/**
 * A simple [Fragment] subclass.
 */
class SetNameFrag : Fragment() {

    private lateinit var binding: FragmentSetNameBinding
    private lateinit var viewModel: SetNameFragViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_name, container, false)

        viewModel = ViewModelProvider(this).get(SetNameFragViewModel::class.java)

        //Here we put some code in the layouts to bind liveData to them.
        //You can see another technique in the other folder of this repository.
        //To see how xml files could be changed: https://developer.android.com/topic/libraries/data-binding/expressions.

        //BEWARE: the viewModel survives configuration changes and, basically, anything which doesn't kill the app.
        //But if the system kills the app in background or you do, the data and the viewModel itself will be destroyed
        //as well.
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val btn = binding.goToNextFragBtn
        btn.setOnClickListener {
            Navigation.findNavController(binding.root).
                navigate(SetNameFragDirections.actionSetNameFragToDisplayNameFrag(viewModel.currentName.value ?: ""))
        }

        return binding.root
    }

}
