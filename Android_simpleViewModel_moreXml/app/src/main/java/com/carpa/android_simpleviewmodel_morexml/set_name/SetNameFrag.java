package com.carpa.android_simpleviewmodel_morexml.set_name;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.carpa.android_simpleviewmodel_morexml.set_name.SetNameFragDirections;
import com.carpa.android_simpleviewmodel_morexml.R;
import com.carpa.android_simpleviewmodel_morexml.databinding.FragmentSetNameBinding;

public class SetNameFrag extends Fragment {

    private FragmentSetNameBinding binding;
    private SetNameFragViewModel viewModel;

    private Button goToNextFragBtn;

    public SetNameFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Using data binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_name, container, false);

        viewModel = new ViewModelProvider(this).get(SetNameFragViewModel.class);

        goToNextFragBtn = binding.goToNextFragBtn;

        //Here we put some code in the layouts to bind liveData to them.
        //You can see another technique in the other folder of this repository.
        //To see how xml files could be changed: https://developer.android.com/topic/libraries/data-binding/expressions.

        //BEWARE: the viewModel survives configuration changes and, basically, anything which doesn't kill the app.
        //But if the system kills the app in background or you do, the data and the viewModel itself will be destroyed
        //as well.

        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);

        goToNextFragBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = viewModel.getName().getValue();
                if(name == null) name = "";
                Navigation.findNavController(binding.getRoot()).
                        navigate(SetNameFragDirections.actionSetNameFragToDisplayNameFrag(name));
            }
        });

        return binding.getRoot();
    }
}
