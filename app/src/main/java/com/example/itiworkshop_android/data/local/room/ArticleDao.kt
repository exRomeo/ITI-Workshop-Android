package com.example.itiworkshop_android.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.TypeConverters
import com.example.itiworkshop_android.data.model.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @TypeConverters(EntityConverter::class)
    @Query("SELECT * FROM article")
    fun getAllLocalArticles() : Flow<List<Article>>

    @Query("DELETE FROM article")
    fun clearAllLocalArticles()

    @TypeConverters(EntityConverter::class)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertArticle(article: Article)

    @TypeConverters(EntityConverter::class)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertArticles(list: List<Article>)

    @TypeConverters(EntityConverter::class)
    @Delete
    fun deleteArticle(article: Article)

    @TypeConverters(EntityConverter::class)
    @Delete
    fun deleteArticles(list: List<Article>)

}