package com.example.elmenus.presentation.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.elmenus.databinding.TagItemBinding
import com.example.elmenus.domain.usecase.LoadPhoto
import com.example.elmenus.presentation.home.TagItemUiState

class TagAdapter(): PagingDataAdapter<TagItemUiState, TagAdapter.TagViewHolder>(Comparator) {


    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        getItem(position)?.let {
                userItemUiState -> holder.bind(userItemUiState)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        val tagBinding = TagItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TagViewHolder(tagBinding)
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


    inner class TagViewHolder(private val tagBinding: TagItemBinding): RecyclerView.ViewHolder(tagBinding.root)
    {
        fun bind(userItemUiState: TagItemUiState) {
            tagBinding.tagName.text=userItemUiState.getName()
            val loadPhoto = LoadPhoto()
            loadPhoto.invoke(tagBinding.tagImage,userItemUiState.getImageUrl(),itemView.context)

            tagBinding.tagCard.setOnClickListener {
                mListener?.onTagClicked(userItemUiState.getName());
            }
        }
    }

    var mListener: TagAdapterListener? = null

    interface TagAdapterListener {
        fun onTagClicked(name: String)
    }
    }

