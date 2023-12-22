package com.android.uiclone

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

class ChatActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chating)
        val btmmenu_home = findViewById<LinearLayout>(R.id.btmmenu_home)
        val btmmenu_locallife = findViewById<LinearLayout>(R.id.btmmenu_locallife)
        val btmmenu_chat = findViewById<LinearLayout>(R.id.btmmenu_chat)
        val btmmenu_myinfo = findViewById<LinearLayout>(R.id.btmmenu_myinfo)
        val tv_local = findViewById<TextView>(R.id.tv_local)
        val iv_qrcode = findViewById<ImageView>(R.id.iv_qrcode)

        tv_local.text= intent.getStringExtra("localarea")

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

        iv_qrcode.setOnClickListener {
            startQrcodeScan()
        }
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