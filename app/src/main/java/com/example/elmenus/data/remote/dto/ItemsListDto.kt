package com.example.elmenus.data.remote.dto

data class ItemListDto(
	val items: List<ItemDto?>? = null
)

data class ItemDto(
	val photoUrl: String? = null,
	val name: String? = null,
	val description: String? = null,
	val id: Int? = null
)

