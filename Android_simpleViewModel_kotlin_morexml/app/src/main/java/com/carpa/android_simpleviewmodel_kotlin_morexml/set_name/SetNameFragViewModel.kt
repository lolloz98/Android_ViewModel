package com.carpa.android_simpleviewmodel_kotlin_morexml.set_name

import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SetNameFragViewModel: ViewModel() {
    val currentName: LiveData<String>
    get() = _currentName

    private val _currentName = MutableLiveData<String>()

    init{
        _currentName.value = ""
    }

    fun onSetBtnClicked(edTxt: EditText){
        _currentName.value = edTxt.text.toString()
        edTxt.setText("")
    }
}