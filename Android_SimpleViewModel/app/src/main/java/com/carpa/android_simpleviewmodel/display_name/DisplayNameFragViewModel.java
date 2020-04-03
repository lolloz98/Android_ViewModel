package com.carpa.android_simpleviewmodel.display_name;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DisplayNameFragViewModel extends ViewModel {

    private MutableLiveData<String> _name;

    public LiveData<String> getName(){
        return _name;
    }

    public DisplayNameFragViewModel(String name){
        _name = new MutableLiveData<String>();
        _name.setValue(name);
    }
}
