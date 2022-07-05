package com.example.examplecalculator.plus

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.examplecalculator.R

class PlusFragment : Fragment() {
    private val mPlusViewModel: PlusViewModel by activityViewModels()
    private var number1: Double? = null
    private var number2: Double? = null
    var result: TextView? = view?.findViewById(R.id.result_plus)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPlusViewModel.getNum1().observe(requireActivity(), Observer {
            Log.d("PlusViewModel", "get value number1 $number1")
            if(number1 == null && number2 == null) return@Observer
            number1 = it as Double

            result?.text = mPlusViewModel.calculate(number1!!, number2!!).toString()
        })

        mPlusViewModel.getNum2().observe(requireActivity(), Observer {
            Log.d("PlusViewModel", "get value number2 $number2")
            if(number1 == null && number2 == null) return@Observer
            number2 = it as Double

            result?.text = mPlusViewModel.calculate(number1!!, number2!!).toString()
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_plus, container, false)

        return view
    }


}