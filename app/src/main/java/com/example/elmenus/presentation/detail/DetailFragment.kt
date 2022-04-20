package com.example.elmenus.presentation.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.elmenus.base.BaseFragment
import com.example.elmenus.data.remote.dto.ItemDto
import com.example.elmenus.databinding.DetailFragmentBinding

class DetailFragment :BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DetailFragmentBinding.inflate(layoutInflater)

       var x= requireArguments().getParcelable<ItemDto>("item")
        Log.d("TAG", "onCreateView: ${x!!.name}")
        return binding.root
    }
}