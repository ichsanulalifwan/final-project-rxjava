package com.app.ichsanulalifwan.barani.core.data.source.remote.response


import com.google.gson.annotations.SerializedName

data class SourceResponse(

    @SerializedName("category")
    val category: String? = "",

    @SerializedName("country")
    val country: String? = "",

    @SerializedName("description")
    val description: String? = "",

    @SerializedName("id")
    val id: String? = "",

    @SerializedName("language")
    val language: String? = "",

    @SerializedName("name")
    val name: String? = "",

    @SerializedName("url")
    val url: String? = "",
)