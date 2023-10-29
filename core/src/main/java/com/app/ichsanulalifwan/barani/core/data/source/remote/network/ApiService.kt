package com.app.ichsanulalifwan.barani.core.data.source.remote.network

import com.app.ichsanulalifwan.barani.core.data.source.remote.response.NewsResponse
import com.app.ichsanulalifwan.barani.core.data.source.remote.response.PublisherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): Single<NewsResponse>

    @GET("v2/top-headlines/sources")
    fun getNewsPublishers(
        @Query("apiKey") apiKey: String
    ): Single<PublisherResponse>

    @GET("v2/everything")
    fun getEverything(
        @Query("q") country: String,
        @Query("apiKey") apiKey: String
    ): Single<NewsResponse>
}