package com.android.uiclone

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.uiclone.databinding.ActivityChatDetailBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

class ChatDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityChatDetailBinding
    private var chatDetail : ChatDetail? = null
    private var chatLog : MutableList<ChatLog>? = null
    private var itemIndex :Int? = null

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.getBundleExtra("data")
        chatDetail = bundle?.getParcelable("chatDetail",ChatDetail::class.java)
        chatLog = bundle?.getParcelableArrayList("chatLog",ChatLog::class.java)
        itemIndex = bundle?.getInt("itemIndex")
        binding.ivChatDetailBack.setOnClickListener {
            onBackPressed()
        }

        binding.tvChatDetailName.text = chatDetail?.personName
        binding.tvChatDetailTemper.text = chatDetail?.temper
        binding.tvTradeStatus.text = chatDetail?.tradeStatus
        binding.tvChatDetailProductName.text = chatDetail?.productName
        binding.tvChatDetailPrice.text = chatDetail?.productPrice
        binding.ivChatDetailPic.setImageResource(chatDetail!!.productPic)

        Log.d("test","채팅내역은 ${chatLog}")
        var chatLogAdapter  = ChatLogAdapter (chatLog!!)
        binding.rvChatDetailChatiing.adapter = chatLogAdapter
        binding.rvChatDetailChatiing.layoutManager = LinearLayoutManager(this)

        binding.ivSendMsg.setOnClickListener {
            if(binding.etChatDetailInput.text.isNotEmpty()) sendMessage()
        }

    }


    private fun sendMessage(){
        val text = binding.etChatDetailInput.text.toString()
        var current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("a h:mm", Locale.KOREA)
        val formatted = current.format(formatter)
        val data= ChatLog(text,formatted,2,R.drawable.background)
        Data.chatLogs[itemIndex!!].add(data)
        (binding.rvChatDetailChatiing.adapter as ChatLogAdapter).addItems(data)
        binding.rvChatDetailChatiing.scrollToPosition(chatLog!!.size-1)
        binding.etChatDetailInput.text.clear()
    }
}