package com.example.examplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.util.Log.d
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.examplecalculator.plus.PlusViewModel
import java.util.*
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timer().schedule(object: TimerTask() {
            override fun run() {
                Log.d("schedule", "task call")
                runOnUiThread{
                    Model.nextNumber1()
                    Model.nextNumber2()
                    val num1 = Model.getNumber1().value
                    val num2 = Model.getNumber2().value
                    updateRandom(num1!!, num2!!)
                }
            }
        }, 0L, 10000L)

    }
    private fun updateRandom(number1: Number, number2: Number) {
        val num1:TextView = findViewById(R.id.tv_number1)
        val num2:TextView = findViewById(R.id.tv_number2)
        num1.text = number1.toString()
        num2.text = number2.toString()

        Model.updateValue(number1, number2)
    }
}