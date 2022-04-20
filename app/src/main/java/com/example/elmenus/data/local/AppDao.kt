package com.example.elmenus.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.elmenus.data.remote.dto.ItemDto
import com.example.elmenus.data.remote.dto.TagDto

@Dao
interface AppDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertAll(tags: List<TagDto>)

    @Query("SELECT * FROM tags order by id")
    fun getAllTags(): PagingSource<Int, TagDto>

    @Query("DELETE FROM Tags")
    suspend fun deleteAll()

    @Insert(onConflict = REPLACE)
    suspend fun insertAllitem(tags: List<ItemDto>)

    @Query("SELECT * FROM items where name like'%' ||:name|| '%'")
    suspend fun getitems(name:String): List<ItemDto>

}