package com.example.tasty.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ClipDescription
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.example.tasty.MainActivity
import com.example.tasty.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlinx.coroutines.channels.Channel
import java.util.*


class MyFirebaseMessagingService:FirebaseMessagingService() {

        //generate the notification
        //attach the notification created with the custom layout
        //show the notification

        lateinit var title: String
        lateinit var message: String
        var Channel_ID = "CHANNEL"
        lateinit var  manager: NotificationManager



        override fun onMessageReceived(remotemessage: RemoteMessage) {

            super.onMessageReceived(remotemessage)
            title = remotemessage.notification!!.title!!
            message = remotemessage.notification!!.body!!


             manager = this.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            sendNotification()


        }

    private fun sendNotification() {
        var intent = Intent(applicationContext,NotificationActivity::class.java)

        intent.putExtra("title",title)
        intent.putExtra("message", message)
        intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TOP
        intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            var channel = NotificationChannel(Channel_ID, "pushnotification", NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel)


        }
        var builder=NotificationCompat.Builder(this, Channel_ID)
            .setContentTitle(title)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setAutoCancel(true)
            .setContentText(message)

        var pendingintent = PendingIntent.getActivity(applicationContext,0,intent,PendingIntent.FLAG_ONE_SHOT)

        builder.setContentIntent(pendingintent)
        manager.notify(0,builder.build())

    }



    override fun onNewToken(token: String) {
            super.onNewToken(token)
        }


    }