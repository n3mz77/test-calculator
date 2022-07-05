package com.example.examplecalculator.minus

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.example.examplecalculator.Model

class MinusViewModel(application: Application) : AndroidViewModel(application) {
    var plusResult =  MutableLiveData<Number?>()

    fun getNum1() : LiveData<Number?> {
        return Model.getNumber1()
    }

    fun getNum2() : LiveData<Number?> {
        return Model.getNumber2()
    }

    fun calculate(number1: Number, number2: Number): Number {
        return Math.subtractExact(number1 as Int, number2 as Int)
    }

    fun calculate(owner: LifecycleOwner): Number? {
        var number1: Number = 0
        var number2: Number = 0
        var result: Number? = null
        val value = MediatorLiveData<Number>()

        Model.getNumber1().observe(owner, Observer{
            Log.d("MinusViewModel", "observe number 1 $it")
            if (it != null) {
                number1 = it
            }
        })

        Model.getNumber2().observe(owner, Observer{
            Log.d("MinusViewModel", "observe number 2 $it")
            if (it != null) {
                number2 = it
                result = Math.subtractExact(number1 as Int, number2 as Int)
                plusResult.value = result
                Log.d("MinusViewModel", "result $result")
            }
        })
        return result
    }

    fun getValue(): LiveData<Number?> {
        return plusResult
    }
}