package com.example.elmenus.data.remote.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class TagsListDto(

	@field:SerializedName("tags")
	val tags: List<TagDto>
)
@Entity(tableName = "Tags")

data class TagDto(
	@PrimaryKey(autoGenerate = true)
	val id:Int,
	@field:SerializedName("photoURL")
	val photoURL: String,

	@field:SerializedName("tagName")
	val tagName: String
)
