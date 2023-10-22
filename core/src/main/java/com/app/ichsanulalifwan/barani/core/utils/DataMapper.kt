package com.app.ichsanulalifwan.barani.core.utils

import com.app.ichsanulalifwan.barani.core.data.remote.response.ArticlesItemResponse
import com.app.ichsanulalifwan.barani.core.model.News
import java.text.SimpleDateFormat
import java.util.*

object DataMapper {

    fun mapResponseToModel(input: List<ArticlesItemResponse>): List<News> {
        val newsList = ArrayList<News>()
        input.map {
            val news =
                News(
                    title = it.title ?: "",
                    author = it.author ?: "",
                    date = it.publishedAt ?: "",
                    image = it.urlToImage ?: "",
                    desc = it.description ?: "",
                    url = it.url ?: "",
                    content = it.content ?: "",
                )
            newsList.add(news)
        }
        return newsList
    }

    fun newsDateFormatter(date: String): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val date = formatter.parse(date)
        val newFormat = SimpleDateFormat("EEEE, dd MMM yyyy", Locale.getDefault())
        return newFormat.format(date)
    }

    fun kknDateFormatter(milliseconds: Long): String {
        val date = Date(milliseconds)
        val newFormat = SimpleDateFormat("EEEE, dd MMM yyyy", Locale.getDefault())
        return newFormat.format(date)
    }
}