package com.example.elmenus.domain.repositry

import androidx.paging.PagingData
import com.example.elmenus.data.local.model.ItemDto
import com.example.elmenus.data.local.model.TagModel
import com.example.elmenus.data.remote.dto.ItemListDto
import com.example.elmenus.data.remote.dto.TagDto

import retrofit2.Response
import kotlinx.coroutines.flow.Flow

interface DataRepo {

    fun getTags(): Flow<PagingData<TagDto>>

    fun getlocalTags(): Flow<PagingData<TagModel>>

    suspend fun getItemsData(name: String): Response<ItemListDto>

    suspend fun addAllItems(list: List<ItemDto>)
}