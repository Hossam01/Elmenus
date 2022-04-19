package com.example.elmenus.data.remote.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class ItemListDto(
	@field:SerializedName("items")
	val items: List<ItemDto>
)

@Parcelize
data class ItemDto(
	@field:SerializedName("photoUrl")
	val photoUrl: String,
	@field:SerializedName("name")
	val name: String,
	@field:SerializedName("description")
	val description: String,
	@field:SerializedName("id")
	val id: Int
): Parcelable

