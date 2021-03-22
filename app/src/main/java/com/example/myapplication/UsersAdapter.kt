package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class UsersAdapter(context: Context, resId: Int, users: List<User>) :
    ArrayAdapter<User>(context, resId, users) {

    private val resID = resId

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
     var view = convertView

        if (view == null) {
            val vi: LayoutInflater = LayoutInflater.from(context)
            view = vi.inflate(resID, null)
        }


        view!!

        val user =  getItem(position)

        user?.let {
            view.findViewById<TextView>(R.id.age_text).text = it.age.toString()
            view.findViewById<TextView>(R.id.name_text).text = it.name
            view.findViewById<TextView>(R.id.surname_text).text = it.surname
        }

        view.setOnClickListener {

        }
        return view

    }

}

