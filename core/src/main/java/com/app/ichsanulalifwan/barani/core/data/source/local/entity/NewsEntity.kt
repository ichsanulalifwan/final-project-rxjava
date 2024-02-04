package com.app.ichsanulalifwan.barani.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_entities")
data class NewsEntity(
    @PrimaryKey
    @ColumnInfo(name = "title")
    var title: String = "",

    @ColumnInfo(name = "author")
    var author: String? = "",

    @ColumnInfo(name = "date")
    var date: String? = "",

    @ColumnInfo(name = "image")
    var image: String? = "",

    @ColumnInfo(name = "desc")
    var desc: String? = "",

    @ColumnInfo(name = "url")
    var url: String? = "",

    @ColumnInfo(name = "content")
    var content: String? = "",

    @ColumnInfo(name = "sourceId")
    var sourceId: String? = "",

    @ColumnInfo(name = "sourceName")
    var sourceName: String? = "",
)