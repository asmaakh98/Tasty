package com.example.tasty

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.content.Intent
import android.widget.Button


@SuppressLint("CustomSplashScreen")
@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
       //window.setFlags(
        //   WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //   WindowManager.LayoutParams.FLAG_FULLSCREEN
       //)

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        //Handler().postDelayed({
          //   val intent = Intent(this, MainActivity::class.java)
            // startActivity(intent)
              //  finish()
        //}, 3000) // 3000 is the delayed time in milliseconds.


        val btnSignUp = findViewById<Button>(R.id.btn_sign_up)
        btnSignUp.setOnClickListener {
           val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

        val btnSignIn = findViewById<Button>(R.id.btn_sign_in)
        btnSignIn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        val btnSkip = findViewById<Button>(R.id.btn_skip)
        btnSkip.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}