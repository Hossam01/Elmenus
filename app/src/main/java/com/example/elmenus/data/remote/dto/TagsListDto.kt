package com.example.elmenus.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TagsListDto(

	@field:SerializedName("tags")
	val tags: List<TagDto?>? = null
)

data class TagDto(

	@field:SerializedName("photoURL")
	val photoURL: String? = null,

	@field:SerializedName("tagName")
	val tagName: String? = null
)
