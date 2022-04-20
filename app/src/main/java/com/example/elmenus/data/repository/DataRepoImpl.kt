package com.example.elmenus.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.elmenus.data.local.AppDao
import com.example.elmenus.data.local.model.ItemDto
import com.example.elmenus.data.local.model.TagModel
import com.example.elmenus.data.paging.TagsPagingSource
import com.example.elmenus.data.remote.dto.ItemListDto
import com.example.elmenus.data.remote.dto.TagDto
import com.example.elmenus.data.remote.webservice.WebService
import com.example.elmenus.domain.repositry.DataRepo
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class DataRepoImpl @Inject constructor(
    val webService: WebService,
    private val photoDao: AppDao
    ) : DataRepo {

    override fun getTags(): Flow<PagingData<TagDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE
            ),
            pagingSourceFactory = { TagsPagingSource(webService,photoDao) }
        ).flow
    }


    override fun getlocalTags(): Flow<PagingData<TagModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE
            ),
            pagingSourceFactory = { photoDao.getAllTags() }
        ).flow
    }


    override suspend fun getItemsData(name: String): Response<ItemListDto> {
        return webService.listItemsByTagName(name)
    }

    override suspend fun addAllItems(list: List<ItemDto>) {
        photoDao.insertAllitem(list)
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 100
    }
}