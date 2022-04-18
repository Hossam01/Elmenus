package com.example.elmenus.data.remote.webservice

import com.example.elmenus.data.remote.dto.ItemListDto
import com.example.elmenus.data.remote.dto.TagsListDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {

    @GET("tags/{page}")
    suspend fun listTags(@Path("page") page: Int): Response<TagsListDto>

    @GET("items/{tagName}")
    suspend fun listItemsByTagName(@Path("tagName") tagName: String): Response<ItemListDto>

}