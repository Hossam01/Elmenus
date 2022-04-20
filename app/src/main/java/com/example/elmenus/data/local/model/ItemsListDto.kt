package com.example.elmenus.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class ItemListDto(
	val items: List<ItemModel>
)

@Entity(tableName = "Items")
data class ItemModel(
	val photoUrl: String,
	@PrimaryKey
	val name: String,
	val description: String,
	val id: Int,
)

