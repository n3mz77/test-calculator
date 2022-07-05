package com.example.examplecalculator.plus

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.example.examplecalculator.Model
import com.example.examplecalculator.NumberRepository

class PlusViewModel(application: Application) : AndroidViewModel(application) {
    val result = MutableLiveData(0)
    fun getResult(owner: LifecycleOwner): LiveData<Int> {
        NumberRepository.getNumber().observe(owner,{
            val (first, second) = it
            result.value = first!!.toInt() + second!!.toInt()
        })

        return result
    }

}