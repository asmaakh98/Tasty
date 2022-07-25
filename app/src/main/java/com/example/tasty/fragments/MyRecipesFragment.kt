package com.example.tasty.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tasty.AddFragment
import com.example.tasty.MyRecipesAdapter
import com.example.tasty.R
import com.example.tasty.database.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_my_recipes.view.*

/**
 * A simple [Fragment] subclass.
 */
class MyRecipesFragment : Fragment(), OnQueryTextListener {

    private lateinit var mRecipeViewModel: RecipeViewModel
    private val adapter = MyRecipesAdapter()

    lateinit var recipeRV: RecyclerView



    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title = "My Recipes"

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_my_recipes, container, false)

        val bt = view.findViewById<Button>(R.id.addButton)
        bt.setOnClickListener {
            val addFragment = AddFragment()
            val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.fl_wrapper, addFragment)
            transaction.commit()
        }

         val btProfile = view.findViewById<Button>(R.id.profileButton)
         btProfile.setOnClickListener {
            val MyprofileFragment = MyProfileFragment()
            val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.fl_wrapper,MyprofileFragment)
            transaction.commit()
        }


        val recyclerView = view.recycleview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        mRecipeViewModel = ViewModelProvider(this)[RecipeViewModel::class.java]
        mRecipeViewModel.readAllData.observe(viewLifecycleOwner, Observer { recipe ->
            adapter.setData(recipe)
        })

        setHasOptionsMenu(true)
        return view


    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater!!.inflate(R.menu.main_menu, menu)

        val search = menu?.findItem(R.id.menu_search)
        val searchView = search?.actionView as? SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(this)

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(query != null){
            searchDatabase(query)
        }
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        if(query != null){
            searchDatabase(query)
        }

        return true
    }

    private fun searchDatabase(query: String) {
        val searchQuery = "%$query%"

        mRecipeViewModel.searchDatabase(searchQuery).observe(viewLifecycleOwner, { recipe ->
            adapter.setData(recipe)

        })
    }


}


