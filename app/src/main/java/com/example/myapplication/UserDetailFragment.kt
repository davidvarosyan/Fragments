package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class UserDetailFragment : Fragment() {

    var user:User? = null
    var listener:UserDetailFragmentListener? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_detail, container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        user?.let {
            view.findViewById<TextView>(R.id.name_text).text = it.name
            view.findViewById<TextView>(R.id.surname_text).text = it.surname
            view.findViewById<TextView>(R.id.age_text).text = it.age.toString()
        }

        view.findViewById<Button>(R.id.button_back).setOnClickListener {
            listener?.onBackButtonPressed()
        }

    }

}

interface UserDetailFragmentListener{
    fun onBackButtonPressed()
}