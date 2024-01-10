package com.android.uiclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.uiclone.databinding.ActivityLocallifeBinding

class LocalLifeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLocallifeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocallifeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btmmenuHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("username", "김경식")
            intent.putExtra("localarea", "천호동")
            startActivity(intent)
        }

        binding.btmmenuLocallife.setOnClickListener {
            val intent = Intent(this, LocalLifeActivity::class.java)
            intent.putExtra("username", "김경식")
            intent.putExtra("localarea", "천호동")
            startActivity(intent)
        }

        binding.btmmenuMyinfo.setOnClickListener {
            val intent = Intent(this, MyinfoActivity::class.java)
            intent.putExtra("username", "김경식")
            intent.putExtra("localarea", "천호동")
            startActivity(intent)
        }

        binding.btmmenuChat.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            intent.putExtra("username", "김경식")
            intent.putExtra("localarea", "천호동")
            startActivity(intent)
        }
        binding.tvLocalarea.text = intent?.getStringExtra("localarea")
        Toast.makeText(
            this,
            "안녕하세요 ${intent?.getStringExtra("username")}님!!!!!",
            Toast.LENGTH_SHORT
        ).show()

        val communityAdapter = CommunityAdapter(Data.communityData)
        binding.rvGroupList.adapter = communityAdapter
        binding.rvGroupList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val localLifePostAdapter = LocalLifePostAdapter(Data.localLifePostData)
        binding.rvLocalLifePostList.adapter = localLifePostAdapter
        binding.rvLocalLifePostList.layoutManager = LinearLayoutManager(this)


    }
}