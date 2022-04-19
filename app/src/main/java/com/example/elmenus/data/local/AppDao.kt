package com.example.elmenus.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.elmenus.data.local.model.TagModel

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(tags: List<TagModel>)

    @Query("DELETE FROM Tags")
    suspend fun deleteAll()
}