package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), UserCreateFragmentListener, UserDetailFragmentListener {

    private val userCreateFragment = UserCreateFragment()
    private val userDetailFragment = UserDetailFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userCreateFragment.userCreateFragmentListener = this
        userDetailFragment.listener = this

        supportFragmentManager.beginTransaction().add(R.id.container, userCreateFragment).commit()
    }


    override fun onUserCreated(user: User) {
        userDetailFragment.user = user
        supportFragmentManager.beginTransaction().replace(R.id.container, userDetailFragment)
            .commit()
    }

    override fun onBackButtonPressed() {
        supportFragmentManager.beginTransaction().replace(R.id.container, userCreateFragment)
            .commit()
    }


}