package com.example.elmenus.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.elmenus.data.local.model.ItemModel
import com.example.elmenus.data.local.model.TagModel

@Database(entities = [TagModel::class, ItemModel::class], version = 4)
abstract class AppDatabase : RoomDatabase(){
    abstract fun dao(): AppDao
}