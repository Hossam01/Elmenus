package com.example.elmenus.presentation.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.elmenus.R

class TagAdapter(): PagingDataAdapter<TagItemUiState, TagAdapter.TagViewHolder>(Comparator) {


    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        getItem(position)?.let { userItemUiState -> holder.bind(userItemUiState) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {

        return  TagViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.tag_item,
                parent,
                false
            )
        )
    }



     object Comparator : DiffUtil.ItemCallback<TagItemUiState>() {
        override fun areItemsTheSame(oldItem: TagItemUiState, newItem: TagItemUiState): Boolean {
            return oldItem.getName() == newItem.getName()
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: TagItemUiState,
            newItem: TagItemUiState
        ): Boolean {
            return oldItem == newItem
        }


    }






    inner class TagViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var textName=itemView.findViewById<TextView>(R.id.tagName)
        var tagImage=itemView.findViewById<ImageView>(R.id.tagImage)
        fun bind(userItemUiState: TagItemUiState) {
            textName.text=userItemUiState.getName()
            Glide.with(itemView.context).load(userItemUiState.getImageUrl()).into(tagImage)
        }
    }

}