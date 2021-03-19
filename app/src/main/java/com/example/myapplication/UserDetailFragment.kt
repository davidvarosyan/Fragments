package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import kotlinx.android.synthetic.main.fragment_user_detail.*

class UserDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_detail, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("createFragment") { _, bundle ->
            bundle.getParcelable<User>("user")?.let {
                name_text.text = it.name
                surname_text.text = it.surname
                age_text.text = it.age.toString()
            }

        }

        button_back.setOnClickListener {
            activity?.apply {
                supportFragmentManager.beginTransaction().hide(this@UserDetailFragment)
                    .show(supportFragmentManager.findFragmentByTag("userCreateFragment")!!).commit()
            }
        }

    }

}
