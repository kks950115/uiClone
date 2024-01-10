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

        binding.tvLocal.text= intent.getStringExtra("localarea")

        binding.btmmenuHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("username","김경식")
            intent.putExtra("localarea","천호동")
            startActivity(intent)
        }

        binding.btmmenuLocallife.setOnClickListener {
            val intent = Intent(this, LocalLifeActivity::class.java)
            intent.putExtra("username","김경식")
            intent.putExtra("localarea","천호동")
            startActivity(intent)
        }

        binding.btmmenuMyinfo.setOnClickListener {
            val intent = Intent(this, MyinfoActivity::class.java)
            intent.putExtra("username","김경식")
            intent.putExtra("localarea","천호동")
            startActivity(intent)
        }

        binding.btmmenuChat.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            intent.putExtra("username","김경식")
            intent.putExtra("localarea","천호동")
            startActivity(intent)
        }

        binding.ivQrcode.setOnClickListener {
            startQrcodeScan()
        }


        val adapter = ChatAdapter(Data.chatData)
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