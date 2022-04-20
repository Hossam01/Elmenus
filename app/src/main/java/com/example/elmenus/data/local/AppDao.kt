package com.example.elmenus.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.elmenus.data.local.model.ItemDto
import com.example.elmenus.data.local.model.TagModel
import com.example.elmenus.data.remote.dto.TagDto

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(tags: List<TagModel>)

    @Query("SELECT * FROM tags order by id")
    fun getAllTags(): PagingSource<Int, TagModel>

    @Query("DELETE FROM Tags")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllitem(tags: List<ItemDto>)


}