package com.carpa.android_simpleviewmodel_kotlin_morexml.display_name

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DisplayNameViewModel(name: String): ViewModel() {

    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
    get() = _name

    init{
        _name.value = name
    }
}