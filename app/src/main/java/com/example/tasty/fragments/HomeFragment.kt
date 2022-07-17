package com.example.tasty.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasty.AddFragment
import com.example.tasty.HomeAdapter
import com.example.tasty.R
import com.example.tasty.database.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var mRecipeViewModel: RecipeViewModel
    private val adapter = HomeAdapter()
    var navc: NavController? = null
    var butc: ImageButton? = null


    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title = "Recipe"

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val bt = view.findViewById<Button>(R.id.addButton)
        bt.setOnClickListener {
            val addFragment = AddFragment()
            val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.fl_wrapper, addFragment)
            transaction.commit()
        }
        val recyclerView = view.recycleview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        mRecipeViewModel = ViewModelProvider(this)[RecipeViewModel::class.java]
        mRecipeViewModel.readAllData.observe(viewLifecycleOwner, Observer { recipe ->
            adapter.setData(recipe)
        })

        return view


    }
}




