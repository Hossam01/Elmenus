package com.example.elmenus.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class ItemListDto(
	val id: Int,
	val name: String,
	val items: List<ItemDto>
)

data class ItemDto(
	val photoUrl: String,
	val name: String,
	val description: String,
	val id: Int
)

