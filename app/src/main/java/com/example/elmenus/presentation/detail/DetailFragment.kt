package com.example.elmenus.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.transition.TransitionInflater
import com.example.elmenus.R
import com.example.elmenus.base.BaseFragment
import com.example.elmenus.data.remote.dto.ItemDto
import com.example.elmenus.databinding.DetailFragmentBinding
import com.example.elmenus.domain.usecase.LoadPhoto
import com.google.android.material.appbar.AppBarLayout

class DetailFragment :BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DetailFragmentBinding.inflate(layoutInflater)
        val loadPhoto=LoadPhoto()
       var itemDto= requireArguments().getParcelable<ItemDto>("item")
        binding.scrollLayout.nameText.text=itemDto!!.name
        binding.scrollLayout.detailText.text=itemDto!!.description
        loadPhoto.invoke(binding.image,itemDto.photoUrl,requireActivity())

        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.fade)
        sharedElementReturnTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.fade)

        binding.appBar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            var isShow = false
            var scrollRange = -1
            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    binding.toolbarLayout.title=itemDto.name
                    isShow = true
                } else if (isShow) {
                    binding.toolbarLayout.title=" "
                    isShow = false
                }
            }
        })
        return binding.root
    }
}