package com.example.tasty.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.tasty.MainActivity
import com.example.tasty.R
import com.example.tasty.database.Person
import com.example.tasty.database.PersonViewModel
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    lateinit var imgPr: String
    companion object {
        val IMAGE_REQUEST_CODE = 1_000;
    }

    private lateinit var mPersonViewModel: PersonViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title = "My Profile"

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        mPersonViewModel = ViewModelProvider(this).get(PersonViewModel::class.java)
        view.personImage.setOnClickListener {
            pickImageFromGallery()
        }

        view.saveProfileBtn.setOnClickListener{

            if(imgPr == ""){
                Toast.makeText(requireContext(), "Please choose an image for your contact", Toast.LENGTH_LONG).show()
            }

            else {
                insertInfoToDatabase()
            }
        }

        view.btnCancel.setOnClickListener {

            requireActivity().run{
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }


        return view
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
            imgPr=data?.data.toString()
            // val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, data?.data)
            // val path = saveImage(bitmap)
            Toast.makeText(requireContext(), "Image Saved!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun insertInfoToDatabase() {
        val FullName=fullName.text.toString()
        val BirthDate=birthDate.text.toString()
        val Location=location.text.toString()
        val Telephone=telephone.text.toString()
        val Email=email.text.toString()

        if (inputCheck(FullName, BirthDate, Telephone, Location, Email)) {

            val person= Person(0,FullName, BirthDate, Location, Telephone, Email, imgPr)

            mPersonViewModel.addPerson(person)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            requireActivity().run {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(fullName: String, birthDate: String, telephone: String, location: String, email: String): Boolean {

        return !(TextUtils.isEmpty(fullName) && TextUtils.isEmpty(birthDate) &&
                TextUtils.isEmpty(telephone) && TextUtils.isEmpty(location) && TextUtils.isEmpty(email))

    }


}

