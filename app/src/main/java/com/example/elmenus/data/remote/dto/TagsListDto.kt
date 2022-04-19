package com.example.elmenus.data.remote.dto

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class TagsListDto(

	@field:SerializedName("tags")
	val tags: List<TagDto>
)

data class TagDto(

	@field:SerializedName("photoURL")
	val photoURL: String,

	@field:SerializedName("tagName")
	val tagName: String
)
