package com.example.examplecalculator

object NumberRepository {
    private val liveData = PairMediatorLiveData(Model.getNumber1(), Model.getNumber2())

    fun getNumber (): PairMediatorLiveData<Number?, Number?> {
        return liveData
    }
}