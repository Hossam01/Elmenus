package com.example.elmenus.domain.repositry

import androidx.paging.PagingData
import com.example.elmenus.data.remote.dto.TagDto
import retrofit2.Response
import kotlinx.coroutines.flow.Flow

interface DataRepo {
    fun getTags(): Flow<PagingData<TagDto>>
}