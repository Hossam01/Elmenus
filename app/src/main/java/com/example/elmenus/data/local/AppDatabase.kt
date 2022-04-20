package com.example.elmenus.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.elmenus.data.remote.dto.ItemDto
import com.example.elmenus.data.remote.dto.TagDto

@Database(entities = [TagDto::class, ItemDto::class], version = 4)
abstract class AppDatabase : RoomDatabase(){
    abstract fun dao(): AppDao
}