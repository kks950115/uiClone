package com.android.uiclone

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android.uiclone.databinding.ActivityChatingBinding
import com.android.uiclone.databinding.ActivityChatingRecyclerviewItemBinding
import com.google.android.material.transition.Hold

class ChatAdapter(val chatItems:MutableList<Chat>) : RecyclerView.Adapter<ChatAdapter.Holder>() {
    inner class Holder(val binding: ActivityChatingRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root){
        val profileImg = binding.ivProfilePic
        val name = binding.tvUserName
        val address = binding.tvAddress
        val time = binding.tvTime
        val content = binding.tvContent
        val contentPic = binding.ivContentPic
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ActivityChatingRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return chatItems.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.profileImg.setImageResource(chatItems[position].prifileImg)
        holder.name.text = chatItems[position].name
        holder.address.text = chatItems[position].address
        holder.time.text = chatItems[position].time
        holder.content.text = chatItems[position].content
        holder.contentPic.setImageResource(chatItems[position].contentImg)

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context ,"게시글 클릭됨",Toast.LENGTH_SHORT).show()
        }
    }
}