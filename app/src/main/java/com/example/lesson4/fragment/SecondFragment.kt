package com.example.lesson4.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.lesson4.R
import com.example.lesson4.utils.ArgumentManager

class SecondFragment : Fragment(R.layout.fragment_second) {

    var textView: TextView? = null
    var counter: TextView? = null


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        textView = view.findViewById(R.id.textView)
        counter = view.findViewById(R.id.counter)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val argumentManager = ArgumentManager()
        val counterValue = argumentManager.getCounter(arguments)
        counter?.text = "$counterValue"

        textView?.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                add(
                        R.id.hostFragmentSecond,
                        SecondFragment::class.java,
                        argumentManager.createArgs(counterValue + 1))
                addToBackStack(null)

                commit()
            }
        }
    }
}