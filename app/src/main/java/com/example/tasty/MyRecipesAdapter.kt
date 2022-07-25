package com.example.tasty

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load

import com.example.tasty.database.Recipe
import kotlinx.android.synthetic.main.layout_list_item.view.*


class MyRecipesAdapter: RecyclerView.Adapter<MyRecipesAdapter.MyViewHolder>() {

    private var recipetList = ArrayList<Recipe>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return recipetList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = recipetList[position]
        val uri: Uri = Uri.parse(currentItem.recipeImg)
        holder.itemView.name.text = currentItem.recipeName
        holder.itemView.recipeImage.load(uri)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
           // holder.itemView.context.startActivity(intent)

            intent.putExtra("img",recipetList[position].recipeImg)
            intent.putExtra("name", recipetList[position].recipeName)
            intent.putExtra("category",recipetList[position].category)
            intent.putExtra("time", recipetList[position].time)
            intent.putExtra("ingredients", recipetList[position].ingredients)
            holder.itemView.context.startActivity(intent)


        }



    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(recipe: List<Recipe>) {
        this.recipetList = recipe as ArrayList<Recipe>
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun deleteRecipe(i: Int){
        recipetList.removeAt(i)
        notifyDataSetChanged()
    }

}

