package com.example.elmenus.presentation.home.adapter

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.Navigation
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.elmenus.R
import com.example.elmenus.data.remote.dto.ItemDto
import com.example.elmenus.databinding.ItemsBinding
import com.example.elmenus.domain.usecase.LoadPhoto
import com.example.elmenus.domain.usecase.LoadPhotoUseCase
import androidx.core.view.ViewCompat

import com.example.elmenus.presentation.MainActivity

import androidx.core.app.ActivityOptionsCompat
import androidx.navigation.fragment.FragmentNavigatorExtras


class ItemAdapter :
    RecyclerView.Adapter<ItemAdapter.ItemHolder>() {



    private val diffCallback = object : DiffUtil.ItemCallback<ItemDto>(){
        override fun areItemsTheSame(oldItem: ItemDto, newItem: ItemDto): Boolean {
            return oldItem.name == newItem.name
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
            val loadPhoto = LoadPhoto()
            loadPhoto.invoke(itemBinding.itemImage,itemDto.photoUrl,itemView.context)
            itemBinding.itemCard.setOnClickListener {
                mListener?.onItemClicked(itemDto)
                val extras = FragmentNavigatorExtras(
                    itemBinding.itemImage to "imageView"
                )
                var bundle=Bundle()
                bundle.putParcelable("item",itemDto)
                Navigation.findNavController(itemBinding.root).navigate(R.id.action_homefragment_to_detailFragment,
                bundle,null,extras)


            }
        }
    }

    var mListener: ItemAdapterListener? = null

    interface ItemAdapterListener {
        fun onItemClicked(item: ItemDto)
    }

}