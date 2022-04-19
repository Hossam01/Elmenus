package com.example.elmenus.presentation.home.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.elmenus.R
import com.example.elmenus.data.remote.dto.ItemDto
import com.example.elmenus.databinding.ItemsBinding

class ItemAdapter :
    RecyclerView.Adapter<ItemAdapter.ItemHolder>() {



    private val diffCallback = object : DiffUtil.ItemCallback<ItemDto>(){
        override fun areItemsTheSame(oldItem: ItemDto, newItem: ItemDto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ItemDto, newItem: ItemDto): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list: List<ItemDto>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        val itemBinding = ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = differ.currentList[position]
        holder.bind(item);
    }

    inner class ItemHolder(private val itemBinding: ItemsBinding):RecyclerView.ViewHolder(itemBinding.root)
    {
        fun bind(itemDto: ItemDto){
            itemBinding.itemName.text=itemDto.name
            itemBinding.itemDescription.text=itemDto.description
            Glide.with(itemView.context).load(itemDto.photoUrl).into(itemBinding.itemImage)
        }
    }


}