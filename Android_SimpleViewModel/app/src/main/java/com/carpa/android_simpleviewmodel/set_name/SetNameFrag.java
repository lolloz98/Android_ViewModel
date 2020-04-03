package com.carpa.android_simpleviewmodel.set_name;

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

import com.carpa.android_simpleviewmodel.R;
import com.carpa.android_simpleviewmodel.databinding.FragmentSetNameBinding;

public class SetNameFrag extends Fragment {

    private FragmentSetNameBinding binding;
    private SetNameFragViewModel viewModel;

    private Button goToNextFragBtn;
    private Button setNameBtn;
    private TextView nameTxt;
    private EditText editedNameEd;

    public SetNameFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Using data binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_name, container, false);

        viewModel = new ViewModelProvider(this).get(SetNameFragViewModel.class);

        nameTxt = binding.nameTextView;
        editedNameEd = binding.setNameEd;
        goToNextFragBtn = binding.goToNextFragBtn;
        setNameBtn = binding.setNameBtn;

        //If we use the power of data binding we can transfer almost all this calls directly into
        //the file xml introducing a variable viewModel.
        //I wanted to show this method to make the reader understand better what's going on.
        //To see how xml files could be changed: https://developer.android.com/topic/libraries/data-binding/expressions.

        //BEWARE: the viewModel survives configuration changes and, basically, anything which doesn't kill the app.
        //But if the system kills the app in background or you do, the data and the viewModel itself will be destroyed
        //as well.
        viewModel.getName().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String name) {
                if(name.equals(""))nameTxt.setText(getString(R.string.select_a_name));
                else nameTxt.setText(getString(R.string.your_name_is, name));
            }
        });

        setNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onSetBtnClicked(editedNameEd.getText().toString());
                editedNameEd.setText("");
            }
        });

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
