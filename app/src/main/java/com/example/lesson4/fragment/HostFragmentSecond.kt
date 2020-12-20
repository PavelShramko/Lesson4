package com.example.lesson4.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lesson4.R

class HostFragmentSecond : Fragment(R.layout.fragment_cont_second) {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cont_second, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val fragment2 = SecondFragment()
        childFragmentManager.beginTransaction().apply {

            setReorderingAllowed(true)
            add(R.id.hostFragmentSecond, fragment2)
            addToBackStack(null)

            commit()
        }
    }
}
