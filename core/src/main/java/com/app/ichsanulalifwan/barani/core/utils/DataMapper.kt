package com.app.ichsanulalifwan.barani.core.utils

import com.app.ichsanulalifwan.barani.core.data.source.remote.response.ArticlesItemResponse
import com.app.ichsanulalifwan.barani.core.data.source.remote.response.SourceResponse
import com.app.ichsanulalifwan.barani.core.model.News
import com.app.ichsanulalifwan.barani.core.model.Publisher
import java.util.*

object DataMapper {

    fun mapNewsListToModel(input: List<ArticlesItemResponse>): List<News> {
        val newsList = ArrayList<News>()
        input.map {
            newsList.add(it.toPublisherModel())
        }

        return newsList
    }

    fun mapPublisherListToModel(input: List<SourceResponse>): List<Publisher> {
        val publisherList = ArrayList<Publisher>()
        input.map {
            publisherList.add(it.toPublisherModel())
        }

        return publisherList
    }

}

internal fun ArticlesItemResponse.toPublisherModel() = News(
    title = title ?: "",
    author = author ?: "",
    date = publishedAt ?: "",
    image = urlToImage ?: "",
    desc = description ?: "",
    url = url ?: "",
    content = content ?: "",
    sourceId = source?.id ?: "",
    sourceName = source?.name ?: ""
)

internal fun SourceResponse.toPublisherModel() = Publisher(
    category = category ?: "",
    country = country ?: "",
    description = description ?: "",
    id = id ?: "",
    language = language ?: "",
    name = name ?: "",
    url = url ?: "",
)