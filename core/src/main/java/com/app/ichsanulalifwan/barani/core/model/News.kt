package com.app.ichsanulalifwan.barani.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val title: String = "",
    val author: String = "",
    val date: String = "",
    val image: String = "",
    val desc: String = "",
    val url: String = "",
    val content: String = "",
    val sourceId: String = "",
    val sourceName: String = "",
): Parcelable