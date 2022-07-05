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
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {
    private var count: Int = 0
    private var number1: Number = 0
    private var number2: Number = 0
    private val mPlusViewModel: PlusViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnUpdate :Button = findViewById(R.id.result_update)
        btnUpdate.setOnClickListener {
            Log.d("check result ", "${mPlusViewModel.calculate(number1, number2)}")
        }

        start()
    }

    private fun start() {
        val timer = object: CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                count = count.plus(1)
                Log.d("test", "count $count")
            }

            override fun onFinish() {
                //calculate
                val random1 = (0..100).shuffled().last()
                val random2 = (0..100).shuffled().last()
                number1 = random1
                number2 = random2

                updateRandom(random1, random2)
                Log.d("test", "finish $count random $random1 & random $random2 ")
                count = 0

                start()
            }
        }
        timer.start()
    }

    private fun updateRandom(number1: Number, number2: Number) {
        val num1:TextView = findViewById(R.id.tv_number1)
        val num2:TextView = findViewById(R.id.tv_number2)
        num1.text = number1.toString()
        num2.text = number2.toString()

        Model().updateValue(number1, number2)
    }
}