package com.app.ichsanulalifwan.barani.core.model

data class Report(
    var judul: String = "",
    var deskripsi: String = "",
    var imageUrl:String = "",
    var userName: String? = "",
    var uploadTime: Long = 0,
    var phoneNumber: String = ""
)