package com.pajokka.manggala.maki.model

data class Report(
    var judul: String = "",
    var deskripsi: String = "",
    var imageUrl:String = "",
    var userName: String? = "",
    var uploadTime: Long = 0,
    var phoneNumber: String = ""
)