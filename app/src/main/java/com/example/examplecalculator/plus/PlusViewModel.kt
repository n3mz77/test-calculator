package com.example.examplecalculator.plus

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.example.examplecalculator.Model

class PlusViewModel(application: Application) : AndroidViewModel(application) {
    var number1 = MutableLiveData<Number?>()
    var number2 =  MutableLiveData<Number?>()
    var valueResult =  MutableLiveData<Number?>()

//    val number1: MutableLiveData<Number?> = Model().getNumber1()
//    val number2: MutableLiveData<Number?> = Model().getNumber2()

//    fun getValue(owner: LifecycleOwner, number1: Number, number2: Number) : MutableLiveData<Number> {
//        Model().getNumber1()
//        Model().getNumber1().observe(owner, Observer {
//            calculate(number1, number2)
//        })
//    }

    fun getNum1() : LiveData<Number?> {
        return Model.getNumber1()
    }

    fun getNum2() : LiveData<Number?> {
        return Model.getNumber2()
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
                valueResult.value = result
                Log.d("PlusViewModel", "result $result")
            }
        })

        //result = Math.addExact(number1 as Int, number2 as Int)
        valueResult.value = result
        return result
    }

    fun getValue(): LiveData<Number?> {
        return valueResult
    }

    fun calculatePlus(number1: Number, number2: Number): Number {
        Model.getNumber1()
        return Math.addExact(number1 as Int, number2 as Int)
    }
}