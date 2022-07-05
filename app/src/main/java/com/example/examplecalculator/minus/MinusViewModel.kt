package com.example.examplecalculator.minus

import android.app.Application
import androidx.lifecycle.*

import com.example.examplecalculator.NumberRepository

class MinusViewModel(application: Application) : AndroidViewModel(application) {

    val result = MutableLiveData(0)
    fun getResult(owner: LifecycleOwner): LiveData<Int> {
        NumberRepository.getNumber().observe(owner,{
            val (first, second) = it
            result.value = first!!.toInt() - second!!.toInt()
        })

        return result
    }
}