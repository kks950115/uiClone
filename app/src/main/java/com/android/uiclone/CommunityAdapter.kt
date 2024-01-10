package com.android.uiclone

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android.uiclone.databinding.ActivityChatingRecyclerviewItemBinding
import com.android.uiclone.databinding.ActivityLocallifeRecyclerviewItemBinding

class CommunityAdapter(val cItems: MutableList<Community>) :
    RecyclerView.Adapter<CommunityAdapter.Holder>() {
    inner class Holder(val binding: ActivityLocallifeRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val pic = binding.ivPic
        val comName = binding.tvName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ActivityLocallifeRecyclerviewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return cItems.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.pic.setImageResource(cItems[position].img)
        holder.comName.text = cItems[position].name
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "커뮤니티 클릭됨", Toast.LENGTH_SHORT).show()
        }
    }


}