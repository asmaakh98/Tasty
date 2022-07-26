package com.example.tasty.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tasty.R
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity() {

    var title = ""
    var message=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        if (intent.extras != null) {
            for (key in intent.extras!!.keySet())
            {
                if (key=="title")
                {
                    title=intent.extras!!.getString("title","")

                }

                if (key=="message")
                {
                    message=intent.extras!!.getString("message","")

                }
            }
        }

        txt_title.text=title
        txt_message.text=message
    }
}