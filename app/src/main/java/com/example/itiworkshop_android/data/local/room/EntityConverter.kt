package com.example.itiworkshop_android.data.local.room

import androidx.room.TypeConverter
import com.example.itiworkshop_android.data.model.Source
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class EntityConverter {

    @TypeConverter
    fun articleSourceToString(source: Source?) : String{
        return Gson().toJson(source)
    }

    @TypeConverter
    fun getArticleSourceFromString(jsonString: String) : Source?{
        val listType: Type =
            object : TypeToken<Source?>() {}.type
        return Gson().fromJson(jsonString, listType)
    }
}