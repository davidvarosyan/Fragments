package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

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

        val createUserButton = view.findViewById<Button>(R.id.button_create_user)
        val nameText = view.findViewById<EditText>(R.id.editTextTextPersonName)
        val surnameText = view.findViewById<EditText>(R.id.editTextTextPersonSurname)
        val ageText = view.findViewById<EditText>(R.id.editTextNumber)

        createUserButton.setOnClickListener {
            val user = User(
                name = nameText.text.toString(),
                surname = surnameText.text.toString(),
                age = ageText.text.toString().toInt()
            )

            userCreateFragmentListener?.onUserCreated(user)
        }

    }



}

interface UserCreateFragmentListener{

    fun onUserCreated(user:User)
}
