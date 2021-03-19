package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_user_create.*

class UserCreateFragment :Fragment(){

    var userCreateFragmentListener:UserCreateFragmentListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_create,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_create_user.setOnClickListener {
            val user = User(
                name = editTextTextPersonName.text.toString(),
                surname = editTextTextPersonSurname.text.toString(),
                age = editTextNumber.text.toString().toInt()
            )

            userCreateFragmentListener?.onUserCreated(user)
        }

    }



}

interface UserCreateFragmentListener{

    fun onUserCreated(user:User)
}
