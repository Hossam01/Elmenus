package com.example.elmenus.data.loacal


import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.elmenus.data.local.AppDao
import com.example.elmenus.data.local.AppDatabase
import com.example.elmenus.data.remote.dto.TagDto
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ElmenusDatabaseTest : TestCase() {
    private lateinit var db: AppDatabase
    private lateinit var dao: AppDao


    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        dao = db.dao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun checkTablehasItemwriteAndReadTag() = runBlocking {
        val language = TagDto(1,"Java", "2 Years")
        dao.insertAll(listOf(language))
        val languages = dao.getAllTagsitem()
        assertThat(languages.contains(language)).isTrue()
    }

    @Test
    fun checkTablehasnotitemdeleteTagsItemandread() = runBlocking {
        val shoppingItem = TagDto(1, "test", "Dessert",)
        dao.insertAll(listOf(shoppingItem))
        dao.deleteAll()
        val allShoppingItems = dao.getAllTagsitem()
        assertThat(allShoppingItems).doesNotContain(shoppingItem)
    }

}