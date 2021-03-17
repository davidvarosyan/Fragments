package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), UserCreateFragmentListener {

    private val userCreateFragment = UserCreateFragment()
    private val userDetailFragment = UserDetailFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userCreateFragment.userCreateFragmentListener = this

        supportFragmentManager.beginTransaction().add(R.id.container1, userCreateFragment).commit()

        supportFragmentManager.beginTransaction().add(R.id.container2, userDetailFragment).commit()

    }

    override fun onUserCreated(user: User) {
        userDetailFragment.user = user

    }


}