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
import com.android.uiclone.databinding.ActivityMyinfoBinding

class MyinfoActivity : AppCompatActivity(){
    private val binding by lazy { ActivityMyinfoBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myinfo)

        binding.tvMypagename.text=intent.getStringExtra("username")
        binding.tvMypagename.setOnClickListener {
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