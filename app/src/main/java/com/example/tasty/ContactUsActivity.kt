package com.example.tasty

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ContactUsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)



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
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/appetizerandroid"))
        }
    }

    fun phClick(view: View)
    {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:0123456789")
        startActivity(intent)
    }

}