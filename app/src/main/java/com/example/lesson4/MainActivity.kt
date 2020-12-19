package com.example.lesson4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson4.fragment.FirstFragment
import com.example.lesson4.fragment.SecondFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {

            supportFragmentManager.beginTransaction().apply {
                val fragment = FirstFragment()

                setReorderingAllowed(true)
                add(R.id.fragment_container_view1, fragment)
                addToBackStack(null)

                commit()
            }
            supportFragmentManager.beginTransaction().apply {
                val fragment = SecondFragment()

                setReorderingAllowed(true)
                add(R.id.fragment_container_view2, fragment)
                addToBackStack(null)

                commit()
            }


        }
    }
}