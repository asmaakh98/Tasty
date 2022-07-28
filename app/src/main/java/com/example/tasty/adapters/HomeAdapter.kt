package com.example.tasty.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tasty.database.Recipe

class HomeAdapter(private val homeList : ArrayList<Recipe>): RecyclerView.Adapter<HomeAdapter.NewViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class NewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}
