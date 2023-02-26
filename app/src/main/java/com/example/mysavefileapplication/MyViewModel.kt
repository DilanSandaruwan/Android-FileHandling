package com.example.mysavefileapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private val _savedText = MutableLiveData<String>(null)
    private val _readText = MutableLiveData<String>(null)

    val savedText: LiveData<String>
        get() = _savedText


    val readText: LiveData<String>
        get() = _readText

    fun setSavingText(value: String) {
        _savedText.value = value
    }

    fun setReadingText(value: String){
        _readText.value = value
    }
}
