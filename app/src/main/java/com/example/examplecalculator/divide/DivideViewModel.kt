package com.example.examplecalculator.divide

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.examplecalculator.Model

class DivideViewModel(application: Application) : AndroidViewModel(application) {
    var plusResult =  MutableLiveData<Number?>()

//    fun getValue() : LiveData<Number?> {
//        var num1 = Model.getNumber2()
//        var num2 = Model.getNumber2().value
//        var result = Math.subtractExact(num1 as Int, num2 as Int)
//        return result
//    }

    fun calculate(owner: LifecycleOwner): Number? {
        var number1: Number = 0
        var number2: Number = 0
        var result: Number? = null
        val value = MediatorLiveData<Number>()

        Model.getNumber1().observe(owner, Observer{
            Log.d("DivideViewModel", "observe number 1 $it")
            if (it != null) {
                number1 = it
            }
        })

        Model.getNumber2().observe(owner, Observer{
            Log.d("DivideViewModel", "observe number 2 $it")
            if (it != null) {
                number2 = it
                //result = number1 as Double / number2 as Double
                plusResult.value = result
                Log.d("DivideViewModel", "result $result")
            }
        })
        return result
    }
}