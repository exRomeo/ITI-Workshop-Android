package com.example.itiworkshop_android.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "article")

data class Article(

    val title: String?,
    val source: Source?,
    val author: String?,
    val description: String?,
    @PrimaryKey
    val url: String,
    val urlToImage: String? =null,
    val publishedAt: String? =null,
    val content: String?=null
//    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
//    val imageAsByteArray: ByteArray
) : Serializable{

  /*  @PrimaryKey
    var articleId: String = content.hashCode().toString()
        set(value) {
            field = value
        }
*/
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Article

        if (title != other.title) return false
        if (source != other.source) return false
        if (author != other.author) return false
        if (description != other.description) return false
        if (url != other.url) return false
        if (urlToImage != other.urlToImage) return false
        if (publishedAt != other.publishedAt) return false
        if (content != other.content) return false
//        if (!imageAsByteArray.contentEquals(other.imageAsByteArray)) return false
//        if (articleId != other.articleId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + (source?.hashCode() ?: 0)
        result = 31 * result + author.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + url.hashCode()
        result = 31 * result + urlToImage.hashCode()
        result = 31 * result + publishedAt.hashCode()
        result = 31 * result + content.hashCode()
//        result = 31 * result + imageAsByteArray.contentHashCode()
//        result = 31 * result + articleId.hashCode()
        return result
    }

}
