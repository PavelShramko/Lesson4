package com.example.lesson4.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lesson4.R

class HostFragmentOne : Fragment(R.layout.fragment_cont_first) {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cont_first, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val fragment1 = FirstFragment()
        childFragmentManager.beginTransaction().apply {

            setReorderingAllowed(true)
            add(R.id.hostFragmentOne, fragment1)
            addToBackStack(null)

            commit()
        }
    }
}

