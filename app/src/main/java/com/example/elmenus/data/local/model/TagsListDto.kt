package com.example.elmenus.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey


data class TagsListDto(
	val tags: List<TagModel>
)

@Entity(tableName = "Tags")
data class TagModel(
	@PrimaryKey
	val tagName: String,
	val photoURL: String
)
