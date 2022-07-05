package com.example.examplecalculator

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

object Model {
    private val mNumber1 = MutableLiveData<Number>(0)
    private val mNumber2 = MutableLiveData<Number>(0)

    fun updateValue(number1: Number, number2: Number) {
        mNumber1.value = number1
        mNumber2.value = number2
        Log.d("Model", "Update Model number1 $number1 & number2 $number2")
    }

    fun randomInt(): Int {
        return (0..10).random()
    }

    fun nextNumber1() {
        mNumber1.value = randomInt()
    }

    fun nextNumber2() {
        mNumber2.value = randomInt()
    }


    fun getNumber1(): MutableLiveData<Number> {
        return mNumber1
    }

    fun getNumber2(): MutableLiveData<Number> {
        return mNumber2
    }
}