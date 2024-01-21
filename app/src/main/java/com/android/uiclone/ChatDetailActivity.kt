package com.android.uiclone

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.android.uiclone.databinding.ActivityChatDetailBinding

class ChatDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityChatDetailBinding
    private var chat : Chat? = null
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.getBundleExtra("chat")
        chat = bundle?.getParcelable("data",Chat::class.java)

        binding.ivChatDetailBack.setOnClickListener {
            onBackPressed()
        }


    }
}