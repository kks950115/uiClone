package com.android.uiclone

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.uiclone.databinding.ActivityChatDetailBinding
import com.android.uiclone.databinding.ActivityChatingBinding
import com.android.uiclone.databinding.ActivityChatingRecyclerviewItemBinding
import com.android.uiclone.databinding.RvLeftChatBoxBinding
import com.android.uiclone.databinding.RvRightChatBoxBinding
import com.google.android.material.transition.Hold

//class ChatLogAdapter(var chatItems:MutableList<ChatLog>) :  ListAdapter<ChatLog, RecyclerView.ViewHolder>(DIFF_CALLBACK)  {
//
//    companion object {
//        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ChatLog>() {
//            override fun areItemsTheSame(oldItem: ChatLog, newItem: ChatLog): Boolean {
//                return oldItem == newItem
//            }
//
//            override fun areContentsTheSame(oldItem: ChatLog, newItem: ChatLog): Boolean {
//                return oldItem == newItem
//            }
//        }
//    }
//
//
//    inner class Holder(val binding: RvLeftChatBoxBinding) : RecyclerView.ViewHolder(binding.root){
//        private val img = binding.ivTvChatboxImg
//        private val content = binding.tvChatboxContent
//        private val time = binding.tvChatboxTime
//        fun bind(item:ChatLog){
//            img.setImageResource(item.img)
//            content.text = item.content
//            time.text = item.time
//        }
//    }
//    inner class Holder2(val binding: RvRightChatBoxBinding) : RecyclerView.ViewHolder(binding.root){
//        private val content2 = binding.tvChatboxContent
//        private val time2 = binding.tvChatboxTime
//        fun bind(item:ChatLog){
//            content2.text = item.content
//            time2.text = item.time
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        Log.d("test","뷰타입은 ${viewType}")
//        if(viewType == Constants.LEFT){
//            return Holder(
//                RvLeftChatBoxBinding.inflate(LayoutInflater.from(parent.context),
//                    parent,
//                    false
//                )
//            )
//        }else{
//            return Holder2(
//                RvRightChatBoxBinding.inflate(
//                    LayoutInflater.from(parent.context),
//                    parent,
//                    false
//                )
//            )
//        }
//
//    }
//
//
//
//    override fun getItemCount(): Int {
//        return chatItems.size
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        when (chatItems[position].viewType){
//            Constants.LEFT -> {
//                (holder as Holder).bind(chatItems[position])
//            }
//            Constants.RIGHT -> {
//                (holder as Holder2).bind(chatItems[position])
//            }
//        }
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return chatItems[position].viewType
//    }
//
//}






class ChatLogAdapter(var chatchatItems:MutableList<ChatLog>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var chatItems = chatchatItems
    inner class Holder(val binding: RvLeftChatBoxBinding) : RecyclerView.ViewHolder(binding.root){
        private val img = binding.ivTvChatboxImg
        private val content = binding.tvChatboxContent
        private val time = binding.tvChatboxTime
        fun bind(item:ChatLog){
            img.setImageResource(item.img)
            content.text = item.content
            time.text = item.time
        }
    }
    inner class Holder2(val binding: RvRightChatBoxBinding) : RecyclerView.ViewHolder(binding.root){
        private val content2 = binding.tvChatboxContent
        private val time2 = binding.tvChatboxTime
        fun bind(item:ChatLog){
            content2.text = item.content
            time2.text = item.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("test","뷰타입은 ${viewType}")
        if(viewType == Constants.LEFT){
            return Holder(
                RvLeftChatBoxBinding.inflate(LayoutInflater.from(parent.context),
                    parent,
                    false
                    )
            )
        }else{
            return Holder2(
                RvRightChatBoxBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

    }



    override fun getItemCount(): Int {
        return chatItems.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (chatItems[position].viewType){
            Constants.LEFT -> {
                (holder as Holder).bind(chatItems[position])
            }
            Constants.RIGHT -> {
                (holder as Holder2).bind(chatItems[position])
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return chatItems[position].viewType
    }

    fun addItems (list:ChatLog){
        chatItems.add(list)
        this.notifyItemInserted(chatItems.size)
    }
}