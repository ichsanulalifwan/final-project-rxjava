package com.app.ichsanulalifwan.barani.core.data.source.remote.network.rxjava

import com.app.ichsanulalifwan.barani.core.data.source.remote.response.NewsResponse
import com.app.ichsanulalifwan.barani.core.data.source.remote.response.PublisherResponse
import com.app.ichsanulalifwan.barani.core.utils.Constant
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RxJavaNewsApiService {

    @GET("v2/top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("category") category: String = "health",
        @Query("apiKey") apiKey: String = Constant.NEWS_API_KEY,
    ): Single<NewsResponse>

    @GET("v2/top-headlines/sources")
    fun getNewsPublishers(
        @Query("apiKey") apiKey: String = Constant.NEWS_API_KEY,
    ): Single<PublisherResponse>

    @GET("v2/everything")
    fun getEverything(
        @Query("q") country: String = "us",
        @Query("apiKey") apiKey: String = Constant.NEWS_API_KEY,
    ): Single<NewsResponse>
}