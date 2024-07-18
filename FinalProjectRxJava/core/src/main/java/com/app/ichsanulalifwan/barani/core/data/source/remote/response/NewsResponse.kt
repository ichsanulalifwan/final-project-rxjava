package com.app.ichsanulalifwan.barani.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class NewsResponse(

    @SerializedName("totalResults")
	val totalResults: Int? = 0,

    @SerializedName("articles")
	val articles: List<ArticlesItemResponse> = emptyList(),

    @SerializedName("status")
	val status: String? = "",
)