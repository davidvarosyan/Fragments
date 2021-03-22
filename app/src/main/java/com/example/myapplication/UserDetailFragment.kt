package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_user_detail.*

class UserDetailFragment : Fragment() {

    var userList:MutableList<User> = mutableListOf()
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


        val adapter = UsersAdapter(context!!,R.layout.list_row , userList)
        users_listView.adapter = adapter
        adapter.notifyDataSetChanged()
        users_listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id -> }


        button_create_user.setOnClickListener {
            listener?.onBackButtonPressed()
        }

    }

}

interface UserDetailFragmentListener{
    fun onBackButtonPressed()
}