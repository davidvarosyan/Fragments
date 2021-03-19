package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userCreateFragment = UserCreateFragment()
        val userDetailFragment = UserDetailFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.container, userCreateFragment, "userCreateFragment").commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.container, userDetailFragment, "userDetailFragment").hide(userDetailFragment)
            .commit()
    }
}