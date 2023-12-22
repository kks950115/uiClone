package com.android.uiclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class LocalLifeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_locallife)
        val btmmenu_home = findViewById<LinearLayout>(R.id.btmmenu_home)
        val btmmenu_locallife = findViewById<LinearLayout>(R.id.btmmenu_locallife)
        val btmmenu_chat = findViewById<LinearLayout>(R.id.btmmenu_chat)
        val btmmenu_myinfo = findViewById<LinearLayout>(R.id.btmmenu_myinfo)
        val localarea= findViewById<TextView>(R.id.tv_localarea)

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
        localarea.text = intent?.getStringExtra("localarea")
        Toast.makeText(this,"안녕하세요 ${intent?.getStringExtra("username")}님!!!!!",Toast.LENGTH_SHORT).show()

    }
}