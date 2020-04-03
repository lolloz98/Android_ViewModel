package com.carpa.android_simpleviewmodel_kotlin_morexml.display_name

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DisplayNameViewModelFactory(val name: String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DisplayNameViewModel(name) as T
    }


}