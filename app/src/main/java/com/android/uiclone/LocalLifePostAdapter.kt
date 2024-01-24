package com.android.uiclone

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.uiclone.databinding.ActivityLocallifeRecyclerviewItemBinding
import com.android.uiclone.databinding.ActivityLocallifepostRecyclerviewItemBinding

class LocalLifePostAdapter(val localLifePosts: MutableList<LocalLifePost>) :
    RecyclerView.Adapter<LocalLifePostAdapter.Holder>() {
    inner class Holder(val binding: ActivityLocallifepostRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root){
        val title = binding.tvTitle
        val tag = binding.tvTag1
        val content = binding.tvLocalLifePostContent
        val contentPic = binding.ivLocalLifePostContentPic
        val address = binding.tvLocalLifePostAddress
        val time = binding.tvLocalLifePostTime
        val viewCount =  binding.tvLocalLifePostViewCount
    }

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ActivityLocallifepostRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return localLifePosts.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.address.text = localLifePosts[position].address
        holder.time.text = localLifePosts[position].time
        holder.title.text = localLifePosts[position].title
        holder.content.text = localLifePosts[position].content
        holder.viewCount.text = localLifePosts[position].viewCoount.toString()
        holder.tag.text = localLifePosts[position].tags[0]
        holder.contentPic.setImageResource(localLifePosts[position].contentPic)
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it,holder.adapterPosition)
            Log.d("test","포스트 어댑터 ${holder.adapterPosition}")
        }
    }
}