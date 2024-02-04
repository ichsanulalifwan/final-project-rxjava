package com.app.ichsanulalifwan.barani.core.utils

import com.app.ichsanulalifwan.barani.core.data.source.local.entity.NewsEntity
import com.app.ichsanulalifwan.barani.core.data.source.local.entity.PublisherEntity
import com.app.ichsanulalifwan.barani.core.data.source.remote.response.ArticlesItemResponse
import com.app.ichsanulalifwan.barani.core.data.source.remote.response.SourceResponse
import com.app.ichsanulalifwan.barani.core.model.News
import com.app.ichsanulalifwan.barani.core.model.Publisher
import java.util.*

object DataMapper {

    fun mapNewsListToModel(input: List<ArticlesItemResponse>): List<News> {
        val newsList = ArrayList<News>()
        input.map {
            newsList.add(it.toNewsModel())
        }

        return newsList
    }

    fun mapNewsEntityToModel(input: List<NewsEntity>): List<News> {
        val newsList = ArrayList<News>()
        input.map {
            newsList.add(it.toNewsModel())
        }

        return newsList
    }

    fun mapPublisherListToModel(input: List<PublisherEntity>): List<Publisher> {
        val publisherList = ArrayList<Publisher>()
        input.map {
            publisherList.add(it.toPublisherModel())
        }

        return publisherList
    }

}

internal fun ArticlesItemResponse.toNewsModel() = News(
    title = title ?: "",
    author = author ?: "",
    date = publishedAt ?: "",
    image = urlToImage ?: "",
    desc = description ?: "",
    url = url ?: "",
    content = content ?: "",
    sourceId = source?.id ?: "",
    sourceName = source?.name ?: "",
)

internal fun ArticlesItemResponse.toNewsEntity() = NewsEntity(
    title = title ?: "",
    author = author ?: "",
    date = publishedAt ?: "",
    image = urlToImage ?: "",
    desc = description ?: "",
    url = url ?: "",
    content = content ?: "",
    sourceId = source?.id ?: "",
    sourceName = source?.name ?: "",
)

internal fun PublisherEntity.toPublisherModel() = Publisher(
    category = category,
    country = country,
    description = description,
    id = id,
    language = language,
    name = name,
    url = url,
)

internal fun SourceResponse.toPublisherEntity() = PublisherEntity(
    category = category ?: "",
    country = country ?: "",
    description = description ?: "",
    id = id ?: "",
    language = language ?: "",
    name = name ?: "",
    url = url ?: "",
)

internal fun NewsEntity.toNewsModel() = News(
    title = title,
    author = author ?: "",
    date = date ?: "",
    image = image ?: "",
    desc = desc ?: "",
    url = url ?: "",
    content = content ?: "",
    sourceId = sourceId ?: "",
    sourceName = sourceName ?: "",
)