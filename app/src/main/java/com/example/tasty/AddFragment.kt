package com.example.tasty

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tasty.database.Recipe
import com.example.tasty.database.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {

    lateinit var img: String
    companion object {
        val IMAGE_REQUEST_CODE = 1_000;
    }

    private lateinit var mRecipeViewModel: RecipeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title = "Add New Recipe"

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mRecipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)
        view.imageView2.setOnClickListener {
            pickImageFromGallery()
        }

        view.saveBtn.setOnClickListener{

            if(img == ""){
                Toast.makeText(requireContext(), "Please choose an image for your contact", Toast.LENGTH_LONG).show()
            }

            else {
                insertDataToDatabase()
            }
        }

        view.cancelBtn.setOnClickListener {

            requireActivity().run{
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }


        return view
    }

    private fun insertDataToDatabase() {
        val Name = name.text.toString()
        val Time = time.text.toString()
        val Ingredients = ingredients.text.toString()
        val Categ = category.text.toString()

        if(inputCheck(Name, Time, Ingredients, Categ)){

            val recipe = Recipe(0, Name, Time, Ingredients, Categ, img)

            mRecipeViewModel.addRecipe(recipe)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            requireActivity().run {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
        else{
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(Name: String, Time: String, Ingredients: String, Categ: String): Boolean {

        return !(TextUtils.isEmpty(Name) && TextUtils.isEmpty(Time) &&
                TextUtils.isEmpty(Ingredients) && TextUtils.isEmpty(Categ))
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // binding.imageView.setImageURI(data?.data)
            //  Toast.makeText(this,""+data?.data,Toast.LENGTH_LONG).show()
            img=data?.data.toString()
            // val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, data?.data)
            // val path = saveImage(bitmap)
            Toast.makeText(requireContext(), "Image Saved!", Toast.LENGTH_SHORT).show()
        }
    }

}