package com.example.itiworkshop_android.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.itiworkshop_android.data.model.Article

@Database(entities = [Article::class],version = 1)
@TypeConverters(EntityConverter::class)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDao() : ArticleDao

    companion object{
        @Volatile
        private var instance: ArticleDatabase? = null

        fun getInstance(context: Context) : ArticleDatabase{
            return instance ?: synchronized(this){
                val temp =
                    Room
                        .databaseBuilder(
                            context.applicationContext,
                            ArticleDatabase::class.java,
                            "articlesdb")
                        .build()
                instance = temp
                return temp
            }
        }
    }
}