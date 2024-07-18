package com.app.ichsanulalifwan.barani.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "publisher_entities")
data class PublisherEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String = "",

    @ColumnInfo(name = "category")
    var category: String = "",

    @ColumnInfo(name = "country")
    var country: String = "",

    @ColumnInfo(name = "description")
    var description: String = "",

    @ColumnInfo(name = "language")
    var language: String = "",

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "url")
    var url: String = "",
)