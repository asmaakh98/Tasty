package com.example.tasty

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_contact_us.*

class ContactUsActivity : AppCompatActivity() {


    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)


        our_location.setOnClickListener{
            val uri = Uri.parse("geo:33.8655844,35.5641728")
            val locationIntent = Intent(Intent.ACTION_VIEW,uri)
            locationIntent.setPackage("com.google.android.apps.maps")
            locationIntent.resolveActivity(packageManager)?.let {
                startActivity(locationIntent)
            }
        }



    }
    fun fbClick(view: View) {
        startActivity(getOpenFacebookIntent());
    }

    private fun getOpenFacebookIntent(): Intent? {

        return try {
            packageManager.getPackageInfo("com.facebook.katana", 0)
            Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/426253597411506"))
        }
        catch (e: Exception) {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/recipesandroid"))
        }
    }

    fun phClick(view: View)
    {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:0123456789")
        startActivity(intent)
    }

}