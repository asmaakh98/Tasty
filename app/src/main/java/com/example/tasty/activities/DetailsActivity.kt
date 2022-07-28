package com.example.tasty.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tasty.R
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        supportActionBar?.title = "Recipe's Details"


        updatedName.setText(intent.getStringExtra("name"))
        updateCategory.setText(intent.getStringExtra("category"))
        updatedTime.setText(intent.getStringExtra("time"))
        updatedIngredients.setText(intent.getStringExtra("ingredients"))
        //updatedRecipeImage.setImageResource(intent.getIntExtra("img"))
    }
}