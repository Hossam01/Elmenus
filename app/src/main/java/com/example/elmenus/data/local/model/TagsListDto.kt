package com.example.elmenus.data.local.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName


data class TagsListDto(
	val tags: List<TagDto>
)

@Entity(tableName = "Tags")
data class TagDto(
	val photoURL: String,
	val tagName: String
)
