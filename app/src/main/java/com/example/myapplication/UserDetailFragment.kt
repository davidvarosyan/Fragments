package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_user_detail.*

class UserDetailFragment : Fragment() {

    var userList: MutableList<User> = mutableListOf()
    var listener: UserDetailFragmentListener? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_detail, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = UserAdapter()
        adapter.userList = userList
        users_recyclerView.adapter = adapter
        users_recyclerView.layoutManager = LinearLayoutManager(context!!)
        adapter.notifyDataSetChanged()

        button_create_user.setOnClickListener {
            listener?.onBackButtonPressed()
        }

    }

}

interface UserDetailFragmentListener {
    fun onBackButtonPressed()
}