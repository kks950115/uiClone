package com.android.uiclone

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MyinfoActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myinfo)

        val btmmenu_home = findViewById<LinearLayout>(R.id.btmmenu_home)
        val btmmenu_locallife = findViewById<LinearLayout>(R.id.btmmenu_locallife)
        val btmmenu_chat = findViewById<LinearLayout>(R.id.btmmenu_chat)
        val btmmenu_myinfo = findViewById<LinearLayout>(R.id.btmmenu_myinfo)
        val mypagename =  findViewById<TextView>(R.id.tv_mypagename)
        val mypagepsa = findViewById<ImageView>(R.id.imageView)

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

        mypagename.text=intent.getStringExtra("username")
        mypagepsa.setOnClickListener {
            openGallery()
        }
    }

    private val pickImageLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val imageUri: Uri? = result.data?.data
                findViewById<ImageView>(R.id.imageView)?.apply {
                    setImageURI(imageUri)
                }
            }
        }

    private fun openGallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        pickImageLauncher.launch(intent)
    }
}