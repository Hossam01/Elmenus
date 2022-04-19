package com.example.elmenus.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.elmenus.data.local.model.ItemListDto
import com.example.elmenus.data.local.model.TagModel

@Database(entities = [TagModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun dao(): AppDao
}