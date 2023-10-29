package com.app.ichsanulalifwan.barani.core.data.repository.news

import com.app.ichsanulalifwan.barani.core.BuildConfig
import com.app.ichsanulalifwan.barani.core.data.source.local.entity.NewsEntity
import com.app.ichsanulalifwan.barani.core.data.source.local.entity.PublisherEntity
import com.app.ichsanulalifwan.barani.core.data.source.local.room.NewsDao
import com.app.ichsanulalifwan.barani.core.data.source.remote.network.ApiService
import com.app.ichsanulalifwan.barani.core.utils.toNewsEntity
import com.app.ichsanulalifwan.barani.core.utils.toPublisherEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

class NewsRepository constructor(
    private val remoteDataSource: ApiService,
    private val localDataSource: NewsDao
) {

    val news: Flowable<List<NewsEntity>>
        get() = localDataSource.allNewsByFlowable()

    val publishers: Flowable<List<PublisherEntity>>
        get() = localDataSource.allPublisherByFlowable()

    fun getTopHeadlineNews(countryCode: String, category: String): Completable =
        remoteDataSource.getTopHeadlines(countryCode, category, API_KEY)
            .flatMapCompletable { newsResponse ->
                insertNewsToDatabase(newsResponse.articles.map {
                    it.toNewsEntity()
                })
            }

    fun getEverythingNews(countryCode: String): Completable =
        remoteDataSource.getEverything(countryCode, API_KEY)
            .flatMapCompletable { response ->
                insertNewsToDatabase(response.articles.map {
                    it.toNewsEntity()
                })
            }

    fun getNewsPublisher(): Completable =
        remoteDataSource.getNewsPublishers(API_KEY)
            .flatMapCompletable { response ->
                insertPublisherToDatabase(response.sources.map {
                    it.toPublisherEntity()
                })
            }

    fun insertNewsToDatabase(newsEntities: List<NewsEntity>): Completable =
        localDataSource.deleteNewsAsCompletable()
            .andThen(localDataSource.insertNewsAsCompletable(newsEntities))
            .subscribeOn(Schedulers.io())

    fun insertPublisherToDatabase(publisherEntities: List<PublisherEntity>): Completable =
        localDataSource.deleteNewsAsCompletable()
            .andThen(localDataSource.insertPublisherAsCompletable(publisherEntities))
            .subscribeOn(Schedulers.io())


    companion object {
        @Volatile
        private var instance: NewsRepository? = null

        private const val API_KEY = BuildConfig.API_KEY

        fun getInstance(
            remoteDataSource: ApiService,
            localDataSource: NewsDao,
        ): NewsRepository =
            instance ?: synchronized(this) {
                instance ?: NewsRepository(
                    remoteDataSource,
                    localDataSource,
                ).apply { instance = this }
            }
    }
}