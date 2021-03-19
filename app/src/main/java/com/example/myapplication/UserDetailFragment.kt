package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import kotlinx.android.synthetic.main.fragment_user_detail.*

class UserDetailFragment : Fragment() {

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


        ViewModelProvider(activity as ViewModelStoreOwner).get(SharedViewModel::class.java).user?.let {
            name_text.text = it.name
            surname_text.text = it.surname
            age_text.text = it.age.toString()
        }

        button_back.setOnClickListener {
            listener?.onBackButtonPressed()
        }

    }

}

interface UserDetailFragmentListener{
    fun onBackButtonPressed()
}