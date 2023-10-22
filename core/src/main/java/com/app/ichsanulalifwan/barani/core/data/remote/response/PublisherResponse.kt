package com.app.ichsanulalifwan.barani.core.data.remote.response


import com.google.gson.annotations.SerializedName

data class PublisherResponse(

    @SerializedName("sources")
    val sources: List<SourceResponse>,

    @SerializedName("status")
    val status: String? = "",
)