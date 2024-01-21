package com.android.uiclone

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.uiclone.databinding.ActivityChatingBinding
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

class ChatActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityChatingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityChatingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val chatData = mutableListOf<Chat>(
            Chat(R.drawable.user, "김경식","천호동","1달전","안녕하세요 ㅎㅎ",R.drawable.angel),
            Chat(R.drawable.user, "김경식1","천호동","1달전","안녕하세요 ㅎㅎ",R.drawable.angel),
            Chat(R.drawable.user, "김경식2","천호동","1달전","안녕하세요 ㅎㅎ",R.drawable.angel),
            Chat(R.drawable.user, "김경식3","천호동","1달전","안녕하세요 ㅎㅎ",R.drawable.angel),
            Chat(R.drawable.user, "김경식4","천호동","1달전","안녕하세요 ㅎㅎ",R.drawable.angel),
            Chat(R.drawable.user, "김경식5","천호동","1달전","안녕하세요 ㅎㅎ",R.drawable.angel),
            Chat(R.drawable.user, "김경식6","천호동","1달전","안녕하세요 ㅎㅎ",R.drawable.angel),
            Chat(R.drawable.user, "김경식7","천호동","1달전","안녕하세요 ㅎㅎ",R.drawable.angel),
            Chat(R.drawable.user, "김경식8","천호동","1달전","안녕하세요 ㅎㅎ",R.drawable.angel),
            Chat(R.drawable.user, "김경식9","천호동","1달전","안녕하세요 ㅎㅎ",R.drawable.angel),
            Chat(R.drawable.user, "김경식10","천호동","1달전","안녕하세요 ㅎㅎ",R.drawable.angel),
            Chat(R.drawable.user, "김경식11","천호동","1달전","안녕하세요 ㅎㅎ",R.drawable.angel),
            Chat(R.drawable.user, "김경식12","천호동","1달전","안녕하세요 ㅎㅎ",R.drawable.angel)
        )

        binding.ivQrcode.setOnClickListener {
            startQrcodeScan()
        }


        val adapter = ChatAdapter(chatData)
        binding.rvChatList.adapter = adapter
        binding.rvChatList.layoutManager = LinearLayoutManager(this)

    }

    private fun startQrcodeScan(){
        val integrator = IntentIntegrator(this)
        with(integrator) {
            setBeepEnabled(false)
            initiateScan()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            val scanRes = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            val content = scanRes.contents

            Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this,"QR코드 인식에 실패했습니다.",Toast.LENGTH_SHORT).show()
        }
    }
}