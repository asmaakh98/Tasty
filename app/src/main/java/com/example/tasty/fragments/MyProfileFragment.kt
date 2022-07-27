package com.example.tasty.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.example.tasty.MainActivity
import com.example.tasty.R
import kotlinx.android.synthetic.main.fragment_my_profile.view.*
import kotlinx.android.synthetic.main.fragment_my_profile.view.btnCancel
import kotlinx.android.synthetic.main.fragment_profile.view.*


class MyProfileFragment : Fragment() {

    private val args by navArgs<MyProfileFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.title = "My Profile"

        val view = inflater.inflate(R.layout.fragment_my_profile, container, false)


        view.btnCancel.setOnClickListener {

            requireActivity().run{
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

    return view
    }


}