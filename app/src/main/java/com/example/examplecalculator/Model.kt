package com.example.examplecalculator

import android.util.Log
import androidx.lifecycle.MutableLiveData

class Model {
    private val mNumber1 = MutableLiveData<Number?>()
    private val mNumber2 = MutableLiveData<Number?>()

    fun updateValue(number1: Number, number2: Number) {
        mNumber1.value = number1
        mNumber2.value = number2
        Log.d("Model", "Update Model number1 $number1 & number2 $number2")
    }

    fun getNumber1(): MutableLiveData<Number?> {
        return mNumber1
    }

    fun getNumber2(): MutableLiveData<Number?> {
        return mNumber2
    }


    fun getValueNumber1(): Number? {
        return mNumber1.value
    }

    fun getValueNumber2(): Number? {
        return mNumber2.value
    }
}