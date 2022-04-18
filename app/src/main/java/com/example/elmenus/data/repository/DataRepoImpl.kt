package com.example.elmenus.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.elmenus.data.paging.TagsPagingSource
import com.example.elmenus.data.remote.dto.TagDto
import com.example.elmenus.data.remote.webservice.WebService
import com.example.elmenus.domain.repositry.DataRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataRepoImpl @Inject constructor(
    val webService: WebService
) : DataRepo {

    override fun getTags(): Flow<PagingData<TagDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE
            ),
            pagingSourceFactory = { TagsPagingSource(webService) }
        ).flow
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 100
    }
}