package com.carpa.android_simpleviewmodel_morexml.display_name;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.carpa.android_simpleviewmodel_morexml.display_name.DisplayNameFragArgs;
import com.carpa.android_simpleviewmodel_morexml.R;
import com.carpa.android_simpleviewmodel_morexml.databinding.FragmentDisplayNameBinding;

public class DisplayNameFrag extends Fragment {

    public DisplayNameFrag() {
        // Required empty public constructor
    }

    private FragmentDisplayNameBinding binding;
    private DisplayNameFragViewModel viewModel;
    private DisplayNameFragViewModelFactory viewModelFactory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_display_name, container, false);

        String name = "";
        if(getArguments() != null)
            name = DisplayNameFragArgs.fromBundle(getArguments()).getNameVal();

        //In this case, it would be fine just to use bundle to pass one string that needs to be constant
        //and then to use OnSaved/RestoredIntsanceState, or another method.
        //I thought it was interesting to show how to create a viewModel able to have a constructor
        //with parameters.
        viewModelFactory = new DisplayNameFragViewModelFactory(name);
        viewModel = new ViewModelProvider(this, viewModelFactory).get(DisplayNameFragViewModel.class);

        binding.setViewModelDisplay(viewModel);

        return binding.getRoot();
    }
}
