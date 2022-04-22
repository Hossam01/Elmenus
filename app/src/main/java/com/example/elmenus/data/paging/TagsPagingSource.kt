package com.example.elmenus.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.elmenus.data.local.AppDao
import com.example.elmenus.data.remote.dto.TagDto
import com.example.elmenus.data.remote.webservice.WebService

class TagsPagingSource(
    private val service: WebService,
    private val dao: AppDao
    ) : PagingSource<Int, TagDto>() {

private lateinit var listOfItems:List<TagDto>
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TagDto> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = service.listTags(page)
            response.body()?.let {
                dao.insertAll(it.tags)
            }
            LoadResult.Page(
                data = response.body()!!.tags,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page.minus(1),
                nextKey = if (response.body()!!.tags.isEmpty()) null else page.plus(1)
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }


    override fun getRefreshKey(state: PagingState<Int, TagDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }


    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }



}