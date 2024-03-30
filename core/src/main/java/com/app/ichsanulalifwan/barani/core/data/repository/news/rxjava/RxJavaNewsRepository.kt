package com.app.ichsanulalifwan.barani.core.data.repository.news.rxjava

import com.app.ichsanulalifwan.barani.core.data.source.local.entity.NewsEntity
import com.app.ichsanulalifwan.barani.core.data.source.local.entity.PublisherEntity
import com.app.ichsanulalifwan.barani.core.data.source.local.room.NewsDao
import com.app.ichsanulalifwan.barani.core.data.source.remote.network.rxjava.RxJavaNewsApiService
import com.app.ichsanulalifwan.barani.core.data.source.remote.response.ArticlesItemResponse
import com.app.ichsanulalifwan.barani.core.utils.toNewsEntity
import com.app.ichsanulalifwan.barani.core.utils.toPublisherEntity
import io.reactivex.BackpressureStrategy
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

class RxJavaNewsRepository(
    private val remoteDataSource: RxJavaNewsApiService,
    private val localDataSource: NewsDao,
) {

    val news: Flowable<List<NewsEntity>>
        get() = localDataSource.allNewsByFlowable()

    val publishers: Flowable<List<PublisherEntity>>
        get() = localDataSource.allPublisherByFlowable()

    fun getTopHeadlineNews(countryCode: String, category: String): Completable =
        remoteDataSource.getTopHeadlines(country = countryCode, category = category)
            .flatMapCompletable { newsResponse ->
                insertNewsToDatabase(newsEntities = newsResponse.articles.map {
                    it.toNewsEntity()
                })
            }

    fun getEverythingNews(countryCode: List<String>): Flowable<List<ArticlesItemResponse>> {
        return Flowable.create({ emitter ->
            val disposables = countryCode.map { code ->
                remoteDataSource.getEverything(country = code)
                    .subscribeOn(Schedulers.io())
                    .map { response -> response.articles }
                    .onErrorReturnItem(emptyList())
                    .subscribe(
                        { articles ->
                            emitter.onNext(articles)
                        },
                        { error ->
                            emitter.onError(error)
                        }
                    )
            }

            emitter.setCancellable {
                disposables.forEach { it.dispose() }
            }
        }, BackpressureStrategy.LATEST)
    }

    fun getNewsPublisher(): Completable =
        remoteDataSource.getNewsPublishers()
            .flatMapCompletable { response ->
                insertPublisherToDatabase(publisherEntities = response.sources.map {
                    it.toPublisherEntity()
                })
            }

    fun insertNewsToDatabase(newsEntities: List<NewsEntity>): Completable =
        localDataSource.deleteNewsAsCompletable()
            .andThen(
                localDataSource.insertNewsAsCompletable(newsEntities = newsEntities)
            ).subscribeOn(Schedulers.io())

    fun insertPublisherToDatabase(publisherEntities: List<PublisherEntity>): Completable =
        localDataSource.deletePublisherAsCompletable()
            .andThen(
                localDataSource.insertPublisherAsCompletable(publisherEntities = publisherEntities)
            ).subscribeOn(Schedulers.io())

    companion object {
        @Volatile
        private var instance: RxJavaNewsRepository? = null

        fun getInstance(
            remoteDataSource: RxJavaNewsApiService,
            localDataSource: NewsDao,
        ): RxJavaNewsRepository =
            instance ?: synchronized(this) {
                instance ?: RxJavaNewsRepository(
                    remoteDataSource = remoteDataSource,
                    localDataSource = localDataSource,
                ).apply { instance = this }
            }
    }
}