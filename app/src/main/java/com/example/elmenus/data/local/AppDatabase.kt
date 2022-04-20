package com.example.elmenus.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.elmenus.data.local.model.ItemDto
import com.example.elmenus.data.local.model.ItemListDto
import com.example.elmenus.data.local.model.TagModel

@Database(entities = [TagModel::class, ItemDto::class], version = 3)
abstract class AppDatabase : RoomDatabase(){
    abstract fun dao(): AppDao
}