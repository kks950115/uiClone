package com.android.uiclone

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.uiclone.databinding.ActivityLocalDetailBinding

class LocalDetailActivity : AppCompatActivity() {

    private val binding by lazy { ActivityLocalDetailBinding.inflate(layoutInflater) }
    private var localLifePost : LocalLifePost? = null
    private var localDetailComment : MutableList<LocalDetailComment>? = null
    private var itemIndex :Int? = null

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bundle = intent.getBundleExtra("data")
        localLifePost = bundle?.getParcelable("localDetail",LocalLifePost::class.java)
        localDetailComment = bundle?.getParcelableArrayList("ccommentLog",LocalDetailComment::class.java)
        itemIndex = bundle?.getInt("itemIndex")
        binding.ivLocalDetailBack.setOnClickListener {
            onBackPressed()
        }
        Log.d("test","locallifepost = ${localLifePost}")
        Log.d("test","localDetailComment = ${localDetailComment}")
        Log.d("test","itemIndex = ${itemIndex}")
        localLifePost?.let {
            binding.ivLocaDetailAddpic.setImageResource(it.contentPic)
            binding.tvLocalDetailAddress.text = it.address
            binding.tvLocalDetailName.text = it.name
            binding.tvLocalDetailContent.text = it.content
            binding.tvContentTitle.text = it.title
        }

        val localDetailCommentAdapter = LocalDetailCommentAdapter(Data.localDetailCommentData[itemIndex!!])
        binding.rvLocalDetailComment.adapter = localDetailCommentAdapter
        binding.rvLocalDetailComment.layoutManager= LinearLayoutManager(this)
    }
}