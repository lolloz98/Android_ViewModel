package com.carpa.android_simpleviewmodel.display_name;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class DisplayNameFragViewModelFactory implements ViewModelProvider.Factory {

    private String _name;

    public DisplayNameFragViewModelFactory(String name){
        _name = name;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)(new DisplayNameFragViewModel(_name));
    }
}
