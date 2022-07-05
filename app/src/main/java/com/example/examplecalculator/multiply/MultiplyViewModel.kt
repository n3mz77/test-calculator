package com.example.examplecalculator.multiply

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.examplecalculator.Model

class MultiplyViewModel(application: Application) : AndroidViewModel(application) {
    var valueResult =  MutableLiveData<Number?>()
    fun calculate(owner: LifecycleOwner): Number? {
        var number1: Number = 0
        var number2: Number = 0
        var result: Number? = null
        val value = MediatorLiveData<Number>()

        Model.getNumber1().observe(owner, Observer{
            Log.d("MultiplyViewModel", "observe number 1 $it")
            if (it != null) {
                number1 = it
            }
        })

        Model.getNumber2().observe(owner, Observer{
            Log.d("MultiplyViewModel", "observe number 2 $it")
            if (it != null) {
                number2 = it
                result = Math.multiplyExact(number1 as Int, number2 as Int)
                valueResult.value = result
                Log.d("MultiplyViewModel", "result $result")
            }
        })

        valueResult.value = result
        return result
    }

    fun getValue(): LiveData<Number?> {
        return valueResult
    }
}