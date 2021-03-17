package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class UserDetailFragment : Fragment() {
    lateinit var nameTextView:TextView
    lateinit var surnameTextView:TextView
    lateinit var ageTextView:TextView


    var user:User? = null

    set(value) {
        field = value
        updateData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_detail, container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameTextView =  view.findViewById(R.id.name_text)

        surnameTextView =  view.findViewById(R.id.surname_text)
        ageTextView =  view.findViewById(R.id.age_text)


       updateData()

    }

    private fun updateData(){
        user?.let {
            nameTextView.text = it.name
            surnameTextView.text = it.surname
            ageTextView.text = it.age.toString()
        }
    }



}
