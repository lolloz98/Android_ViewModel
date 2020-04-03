package com.carpa.android_simpleviewmodel.set_name;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ResourceBundle;

public class SetNameFragViewModel extends ViewModel {
    private MutableLiveData<String> _name;

    public LiveData<String> getName(){
        if(_name == null)
            _name = new MutableLiveData<String>();
        return _name;
    }

    public SetNameFragViewModel(){
        //empty constructor
    }

    public void onSetBtnClicked(String txt){
        _name.setValue(txt);
    }
}
