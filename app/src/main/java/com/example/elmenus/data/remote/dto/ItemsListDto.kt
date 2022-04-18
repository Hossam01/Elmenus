package com.example.elmenus.data.remote.dto

data class ItemListDto(
	val items: List<ItemDto>
)

data class ItemDto(
	val photoUrl: String,
	val name: String,
	val description: String,
	val id: Int
)

