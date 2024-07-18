package com.app.ichsanulalifwan.barani.core.data.source.remote.network.rxjava

import com.app.ichsanulalifwan.barani.core.data.source.remote.response.NewsResponse
import com.app.ichsanulalifwan.barani.core.data.source.remote.response.PublisherResponse
import com.app.ichsanulalifwan.barani.core.utils.Constant
import com.app.ichsanulalifwan.barani.core.utils.Constant.HEALTH_CATEGORY
import com.app.ichsanulalifwan.barani.core.utils.Constant.US_COUNTRY_CODE
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RxJavaNewsApiService {

    @GET("v2/top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String = US_COUNTRY_CODE,
        @Query("category") category: String = HEALTH_CATEGORY,
        @Query("apiKey") apiKey: String = Constant.NEWS_API_KEY,
    ): Single<NewsResponse>

    @GET("v2/top-headlines/sources")
    fun getNewsPublishers(
        @Query("apiKey") apiKey: String = Constant.NEWS_API_KEY,
    ): Single<PublisherResponse>

    @GET("v2/everything")
    fun getEverything(
        @Query("q") country: String = US_COUNTRY_CODE,
        @Query("apiKey") apiKey: String = Constant.NEWS_API_KEY,
    ): Single<NewsResponse>
}