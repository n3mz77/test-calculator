package com.example.examplecalculator.divide

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
import com.example.examplecalculator.multiply.MultiplyViewModel

class DivideFragment : Fragment() {
    private val mDivideViewModel: DivideViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDivideViewModel.calculate(requireActivity())
        mDivideViewModel.plusResult.observe(requireActivity(), Observer {
            Log.d("DivideViewModel", "get value $it")
            val result: TextView? = view?.findViewById(R.id.result_divide)
            result?.text = it.toString()
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_divide, container, false)
    }
}