package com.app.ichsanulalifwan.barani.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "publisher_entities")
data class PublisherEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String = "",

    @ColumnInfo(name = "category")
    val category: String = "",

    @ColumnInfo(name = "country")
    val country: String = "",

    @ColumnInfo(name = "description")
    val description: String = "",

    @ColumnInfo(name = "language")
    val language: String = "",

    @ColumnInfo(name = "name")
    val name: String = "",

    @ColumnInfo(name = "url")
    val url: String = "",
)