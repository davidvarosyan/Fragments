package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    var userList: MutableList<User> = mutableListOf()

   lateinit var clickListener:ClickListener

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_row, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.user = userList[position]
        holder.itemView.setOnClickListener {

        }
        holder.itemView.setOnClickListener {
            clickListener.onItemClick(position, userList[position])
        }
        holder.init()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        lateinit var user: User

        fun init() {
            itemView.apply {
                findViewById<TextView>(R.id.name_text).text = user.name
                findViewById<TextView>(R.id.surname_text).text = user.surname
                findViewById<TextView>(R.id.age_text).text = user.age.toString()
            }
            itemView.invalidate()
        }
    }

    interface ClickListener{
        fun onItemClick(position:Int , user:User)
    }

}