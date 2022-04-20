package com.example.elmenus.domain.repositry

import androidx.paging.PagingData
import com.example.elmenus.data.remote.dto.ItemDto
import com.example.elmenus.data.remote.dto.ItemListDto
import com.example.elmenus.data.remote.dto.TagDto

import retrofit2.Response
import kotlinx.coroutines.flow.Flow

interface DataRepo {

    fun getTags(): Flow<PagingData<TagDto>>

    fun getlocalTags(): Flow<PagingData<TagDto>>

    suspend fun getItemsData(name: String): Response<ItemListDto>

    suspend fun addAllItems(list: List<ItemDto>)

    suspend fun getitem(name: String):List<ItemDto>
}