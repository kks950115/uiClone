package com.android.uiclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android.uiclone.databinding.ActivityChatDetailBinding
import com.android.uiclone.databinding.ActivityChatingBinding
import com.android.uiclone.databinding.ActivityChatingRecyclerviewItemBinding
import com.google.android.material.transition.Hold

class ChatDetailAdapter(val chatItems:MutableList<ChatDetail>) : RecyclerView.Adapter<ChatDetailAdapter.Holder>() {
    inner class Holder(val binding: ActivityChatDetailBinding) : RecyclerView.ViewHolder(binding.root){
        val name = binding.tvChatDetailName
        val temper = binding.tvChatDetailTemper
        val tradeStatus = binding.tvTradeStatus
        val producetName = binding.tvChatDetailProductName
        val productPrice = binding.tvChatDetailPrice
        val productPic = binding.ivChatDetailPic
    }

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }
    var itemClick : ItemClick? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ActivityChatDetailBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }



    override fun getItemCount(): Int {
        return chatItems.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.productPic.setImageResource(chatItems[position].productPic)
        holder.name.text = chatItems[position].personName
        holder.tradeStatus.text = chatItems[position].tradeStatus
        holder.producetName .text = chatItems[position].productName
        holder.productPrice.text = chatItems[position].productPrice
        holder.temper.text = chatItems[position].temper

        holder.itemView.setOnClickListener {
            itemClick?.onClick(it,holder.adapterPosition)
        }
    }
}