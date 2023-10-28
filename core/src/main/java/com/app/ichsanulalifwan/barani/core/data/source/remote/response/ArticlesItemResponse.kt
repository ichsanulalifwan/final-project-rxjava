package com.app.ichsanulalifwan.barani.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ArticlesItemResponse(

    @SerializedName("publishedAt")
    val publishedAt: String? = "",

    @SerializedName("author")
    val author: String? = "",

    @SerializedName("urlToImage")
    val urlToImage: String? = "",

    @SerializedName("description")
    val description: String? = "",

    @SerializedName("source")
    val source: SourceResponse? = SourceResponse(),

    @SerializedName("title")
    val title: String? = "",

    @SerializedName("url")
    val url: String? = "",

    @SerializedName("content")
    val content: String? = "",
)