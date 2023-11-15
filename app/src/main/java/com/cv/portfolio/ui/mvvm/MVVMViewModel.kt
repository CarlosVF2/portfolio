package com.cv.portfolio.ui.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * View model for MVVM Fragment
 */
class MVVMViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Actually doesn't change the value"
    }

    var text: LiveData<String> = _text

    fun changeText(text : String){
        _text.value = text
    }
}