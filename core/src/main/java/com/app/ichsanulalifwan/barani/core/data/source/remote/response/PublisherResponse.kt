package com.app.ichsanulalifwan.barani.core.data.source.remote.response


import com.google.gson.annotations.SerializedName

data class PublisherResponse(

    @SerializedName("sources")
    val sources: List<SourceResponse> = emptyList(),

    @SerializedName("status")
    val status: String? = "",
)