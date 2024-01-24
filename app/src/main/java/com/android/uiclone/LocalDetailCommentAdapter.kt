package com.android.uiclone

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.uiclone.databinding.ActivityChatingRecyclerviewItemBinding
import com.android.uiclone.databinding.RvLeftChatBoxBinding
import com.android.uiclone.databinding.RvLocallifeDetailCommentBinding
import com.android.uiclone.databinding.RvRightChatBoxBinding

class LocalDetailCommentAdapter (var commentItems:MutableList<LocalDetailComment>) : RecyclerView.Adapter<LocalDetailCommentAdapter.Holder>() {

    inner class Holder(val binding: RvLocallifeDetailCommentBinding) : RecyclerView.ViewHolder(binding.root){
        val personPic = binding.ivLocalCommentPic
        val content = binding.tvLocalCommentContent
        val name = binding.tvLocalCommentName
        val address = binding.tvLocalCommentAddress

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RvLocallifeDetailCommentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }


    override fun getItemCount(): Int {
            return commentItems.size
        }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.name.text = commentItems[position].name
        holder.address.text = commentItems[position].address
        holder.content .text = commentItems[position].content
        holder.personPic.setImageResource(commentItems[position].personPic)

    }


}