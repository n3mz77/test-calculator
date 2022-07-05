package com.example.examplecalculator

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

object Model {
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

    fun calculate(owner: LifecycleOwner): Number? {
        var number1: Number = 0
        var number2: Number = 0
        var result: Number? = null
        val value = MediatorLiveData<Number>()

        Model.getNumber1().observe(owner, Observer{
            Log.d("PlusViewModel", "observe number 1 $it")
            if (it != null) {
                number1 = it
            }
        })

        Model.getNumber2().observe(owner, Observer{
            Log.d("PlusViewModel", "observe number 2 $it")
            if (it != null) {
                number2 = it
                result = Math.addExact(number1 as Int, number2 as Int)
                //plusResult.value = result
                Log.d("PlusViewModel", "result $result")
            }
        })

        //result = Math.addExact(number1 as Int, number2 as Int)
        //plusResult.value = result
        return result
    }

//    fun getValue(): LiveData<Number?> {
//        return plusResult
//    }
}