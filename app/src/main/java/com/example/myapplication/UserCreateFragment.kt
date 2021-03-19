package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import kotlinx.android.synthetic.main.fragment_user_create.*

class UserCreateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_create, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_create_user.setOnClickListener {

            val user = User(
                name = editTextTextPersonName.text.toString(),
                surname = editTextTextPersonSurname.text.toString(),
                age = editTextNumber.text.toString().toInt()
            )

            setFragmentResult("createFragment", bundleOf("user" to user))

            activity?.apply {
                supportFragmentManager.beginTransaction().hide(this@UserCreateFragment)
                    .show(supportFragmentManager.findFragmentByTag("userDetailFragment")!!).commit()
            }

        }

    }
}