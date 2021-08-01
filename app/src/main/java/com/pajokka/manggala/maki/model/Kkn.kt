package com.pajokka.manggala.maki.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Kkn(
    var author: String = "",
    var content: String = "",
    var createdAt: Long = 0,
    var imageUrl: String = "",
    var title: String = "",
    var updatedAt: Long = 0,
    var views: Int = 0
) : Parcelable