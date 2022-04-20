package com.example.elmenus.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class ItemListDto(
	val items: List<ItemDto>
)

@Entity(tableName = "Items")
data class ItemDto(
	val photoUrl: String,
	val name: String,
	val description: String,
	@PrimaryKey
	val id: Int
)

