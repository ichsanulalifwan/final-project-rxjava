package com.app.ichsanulalifwan.barani.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_entities")
data class NewsEntity(
    @PrimaryKey
    @ColumnInfo(name = "title")
    val title: String? = "",

    @ColumnInfo(name = "author")
    val author: String? = "",

    @ColumnInfo(name = "date")
    val date: String? = "",

    @ColumnInfo(name = "image")
    val image: String? = "",

    @ColumnInfo(name = "desc")
    val desc: String? = "",

    @ColumnInfo(name = "url")
    val url: String? = "",

    @ColumnInfo(name = "content")
    val content: String? = "",

    @ColumnInfo(name = "sourceId")
    val sourceId: String? = "",

    @ColumnInfo(name = "sourceName")
    val sourceName: String? = "",
)