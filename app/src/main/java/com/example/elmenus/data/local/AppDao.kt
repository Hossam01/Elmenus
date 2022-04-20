package com.example.elmenus.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.elmenus.data.local.model.ItemModel
import com.example.elmenus.data.local.model.TagModel

@Dao
interface AppDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertAll(tags: List<TagModel>)

    @Query("SELECT * FROM tags order by id")
    fun getAllTags(): PagingSource<Int, TagModel>

    @Query("DELETE FROM Tags")
    suspend fun deleteAll()

    @Insert(onConflict = REPLACE)
    suspend fun insertAllitem(tags: List<ItemModel>)

    @Query("SELECT * FROM items where name like'%' ||:name|| '%'")
    suspend fun getitems(name:String): List<ItemModel>

}