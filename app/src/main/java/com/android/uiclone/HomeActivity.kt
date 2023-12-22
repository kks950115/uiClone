package com.android.uiclone

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btmmenu_home = findViewById<LinearLayout>(R.id.btmmenu_home)
        val btmmenu_locallife = findViewById<LinearLayout>(R.id.btmmenu_locallife)
        val btmmenu_chat = findViewById<LinearLayout>(R.id.btmmenu_chat)
        val btmmenu_myinfo = findViewById<LinearLayout>(R.id.btmmenu_myinfo)

        btmmenu_home.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("username","김경식")
            intent.putExtra("localarea","천호동")
            startActivity(intent)
        }

        btmmenu_locallife.setOnClickListener {
            val intent = Intent(this, LocalLifeActivity::class.java)
            intent.putExtra("username","김경식")
            intent.putExtra("localarea","천호동")
            startActivity(intent)
        }

        btmmenu_myinfo.setOnClickListener {
            val intent = Intent(this, MyinfoActivity::class.java)
            intent.putExtra("username","김경식")
            intent.putExtra("localarea","천호동")
            startActivity(intent)
        }

        btmmenu_chat.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            intent.putExtra("username","김경식")
            intent.putExtra("localarea","천호동")
            startActivity(intent)
        }
    }
}