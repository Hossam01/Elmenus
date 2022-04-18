package com.example.elmenus.presentation.home

import com.example.elmenus.base.BaseUiState
import com.example.elmenus.data.remote.dto.TagDto

class TagItemUiState (private val tagModel: TagDto) : BaseUiState(){

    fun getImageUrl() = tagModel.photoURL

    fun getName() = tagModel.tagName

}