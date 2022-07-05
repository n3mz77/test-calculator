package com.example.examplecalculator.minus

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.examplecalculator.Model

class MinusViewModel(application: Application) : AndroidViewModel(application) {

    val number1: MutableLiveData<Number?> = Model().getNumber1()
    val number2: MutableLiveData<Number?> = Model().getNumber2()


    fun getNum1() : MutableLiveData<Number?> {
        return Model().getNumber1()
    }

    fun getNum2() : MutableLiveData<Number?> {
        return Model().getNumber2()
    }

    fun calculate(number1: Number, number2: Number): Number {
        return Math.subtractExact(number1 as Int, number2 as Int)
    }
}