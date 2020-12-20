package com.example.lesson4

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson4.fragment.HostFragmentOne
import com.example.lesson4.fragment.HostFragmentSecond

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: Button? = findViewById(R.id.buttonFirst)
        val button2: Button? = findViewById(R.id.buttonSecond)

        val fragment1 = HostFragmentOne()
        val fragment2 = HostFragmentSecond()

        if (savedInstanceState == null) {

            supportFragmentManager.beginTransaction().apply {


                setReorderingAllowed(true)
                add(R.id.fragment_container_view, fragment1)
                addToBackStack("HostFragmentOne")
                add(R.id.fragment_container_view, fragment2)
                addToBackStack("HostFragmentSecond")

                commit()
            }
        }

        button1?.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {

                setReorderingAllowed(true)
                setPrimaryNavigationFragment(fragment1)
                hide(fragment2)
                show(fragment1)
                addToBackStack(null)

                commit()
            }
        }

        button2?.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {

                setReorderingAllowed(true)
                setPrimaryNavigationFragment(fragment2)
                hide(fragment1)
                show(fragment2)
                addToBackStack(null)

                commit()
            }
        }
    }
}