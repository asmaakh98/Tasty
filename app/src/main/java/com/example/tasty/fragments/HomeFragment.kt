package com.example.tasty.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.tasty.activities.ContactUsActivity
import com.example.tasty.R
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    lateinit var recipeRV: RecyclerView
    lateinit var mDatabase: DatabaseReference

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.title = "Recipes"

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val recipeRV = view.recycleviewfav
        // mDatabase = FirebaseDatabase.getInstance().getReference("Recipes")

        val btProfile = view.findViewById<Button>(R.id.profileButton)
        btProfile.setOnClickListener {
            val MyprofileFragment = MyProfileFragment()
            val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.fl_wrapper, MyprofileFragment)
            transaction.commit()
        }

        val btnContact = view.findViewById<Button>(R.id.contact_us_btn)
        btnContact.setOnClickListener {
            activity?.let{
                val intent = Intent (it, ContactUsActivity::class.java)
                it.startActivity(intent)
            }

        }
        return view
    }
}


