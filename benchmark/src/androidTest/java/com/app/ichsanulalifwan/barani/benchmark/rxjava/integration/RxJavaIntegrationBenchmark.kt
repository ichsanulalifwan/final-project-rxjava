package com.app.ichsanulalifwan.barani.benchmark.rxjava.integration

import android.annotation.SuppressLint
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.app.ichsanulalifwan.barani.benchmark.api.IntegrationBenchmark
import com.app.ichsanulalifwan.barani.benchmark.rxjava.RxJavaBenchmark
import com.app.ichsanulalifwan.barani.core.utils.toNewsEntity
import io.reactivex.BackpressureStrategy
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import org.junit.Test
import org.junit.runner.RunWith

@SuppressLint("CheckResult")
@RunWith(AndroidJUnit4::class)
class RxJavaIntegrationBenchmark : RxJavaBenchmark(), IntegrationBenchmark {

    @Test
    override fun integration1() = benchmarkRule.measureRepeated {
        runWithTimingDisabled { localDataSource.deleteNewsAsCompletable().blockingAwait() }
        remoteDataSource.getTopHeadlines()
            .flatMap { repository.getEverythingNews(List(20) { "us" }) }
            .flatMapCompletable { listResponse ->
                repository.insertNewsToDatabase(
                    listResponse.map { itemResponse ->
                        itemResponse.toNewsEntity()
                    }
                )
            }
            .blockingAwait()
    }

    @Test
    override fun integration2() = benchmarkRule.measureRepeated {
        runWithTimingDisabled { localDataSource.deleteNewsAsCompletable().blockingAwait() }
        remoteDataSource.getTopHeadlines()
            .flatMap { remoteDataSource.getTopHeadlines() }
            .flatMap { repository.getEverythingNews(List(20) { "us" }) }
            .flatMap { repository.getEverythingNews(List(20) { "us" }) }
            .flatMapCompletable { listResponse ->
                repository.insertNewsToDatabase(
                    listResponse.map { itemResponse ->
                        itemResponse.toNewsEntity()
                    }
                )
                    .andThen(repository.insertNewsToDatabase(listResponse.map { itemResponse -> itemResponse.toNewsEntity() }))
            }.blockingAwait()
    }

    @Test
    override fun integration3() = benchmarkRule.measureRepeated {
        runWithTimingDisabled { localDataSource.deleteNewsAsCompletable().blockingAwait() }
        remoteDataSource.getTopHeadlines()
            .flatMap { remoteDataSource.getTopHeadlines() }
            .flatMap { remoteDataSource.getTopHeadlines() }
            .flatMap { repository.getEverythingNews(List(20) { "us" }) }
            .flatMap { repository.getEverythingNews(List(20) { "us" }) }
            .flatMap { repository.getEverythingNews(List(20) { "us" }) }
            .flatMapCompletable { listResponse ->
                repository.insertNewsToDatabase(
                    listResponse.map { itemResponse ->
                        itemResponse.toNewsEntity()
                    }
                )
                    .andThen(repository.insertNewsToDatabase(listResponse.map { itemResponse -> itemResponse.toNewsEntity() }))
                    .andThen(repository.insertNewsToDatabase(listResponse.map { itemResponse -> itemResponse.toNewsEntity() }))
                    .andThen(Completable.complete())
            }.blockingAwait()
    }

    @Test
    override fun integration4() = benchmarkRule.measureRepeated {
        runWithTimingDisabled { localDataSource.deleteNewsAsCompletable().blockingAwait() }
        remoteDataSource.getTopHeadlines()
            .flatMap { remoteDataSource.getTopHeadlines() }
            .flatMap { remoteDataSource.getTopHeadlines() }
            .flatMap { remoteDataSource.getTopHeadlines() }
            .flatMap { repository.getEverythingNews(List(20) { "us" }) }
            .flatMap { repository.getEverythingNews(List(20) { "us" }) }
            .flatMap { repository.getEverythingNews(List(20) { "us" }) }
            .flatMap { repository.getEverythingNews(List(20) { "us" }) }
            .flatMapCompletable { listResponse ->
                repository.insertNewsToDatabase(listResponse.map { itemResponse -> itemResponse.toNewsEntity() })
                    .andThen(repository.insertNewsToDatabase(listResponse.map { itemResponse -> itemResponse.toNewsEntity() }))
                    .andThen(repository.insertNewsToDatabase(listResponse.map { itemResponse -> itemResponse.toNewsEntity() }))
                    .andThen(repository.insertNewsToDatabase(listResponse.map { itemResponse -> itemResponse.toNewsEntity() }))
                    .andThen(Completable.complete())
            }.blockingAwait()
    }

    @Test
    override fun integrationReactive() = benchmarkRule.measureRepeated {

        val flowable = Flowable.create({ emitter ->
            emitter.onNext(remoteDataSource.getTopHeadlines().blockingGet())
        }, BackpressureStrategy.LATEST)
            .flatMapSingle { remoteDataSource.getNewsPublishers() }
            .subscribeOn(Schedulers.io())

        flowable.blockingFirst()
    }
}