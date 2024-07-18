package com.app.ichsanulalifwan.barani.benchmark.rxjava.integration

import android.annotation.SuppressLint
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.app.ichsanulalifwan.barani.benchmark.api.IntegrationBenchmark
import com.app.ichsanulalifwan.barani.benchmark.rxjava.RxJavaBenchmark
import com.app.ichsanulalifwan.barani.core.utils.toNewsEntity
import io.reactivex.Completable
import org.junit.Test
import org.junit.runner.RunWith

@SuppressLint("CheckResult")
@RunWith(AndroidJUnit4::class)
class RxJavaIntegrationBenchmark : RxJavaBenchmark(), IntegrationBenchmark {

    @Test
    override fun integration1() = benchmarkRule.measureRepeated {
        runWithTimingDisabled { localDataSource.deleteAllNews().blockingAwait() }
        remoteDataSource.getTopHeadlines()
            .flatMap {
                repository.getEverythingNews(List(10) { "us" })
            }
            .flatMapCompletable { listResponse ->
                repository.insertNewsToDatabase(
                    listResponse.map { itemResponse ->
                        itemResponse.toNewsEntity()
                    }
                )
            }.blockingAwait()
    }

    @Test
    override fun integration2() = benchmarkRule.measureRepeated {
        runWithTimingDisabled { localDataSource.deleteAllNews().blockingAwait() }
        remoteDataSource.getTopHeadlines()
            .flatMap { remoteDataSource.getTopHeadlines() }
            .flatMap { repository.getEverythingNews(List(10) { "us" }) }
            .flatMap { repository.getEverythingNews(List(10) { "us" }) }
            .flatMapCompletable { listResponse ->
                repository.insertNewsToDatabase(
                    listResponse.map { itemResponse ->
                        itemResponse.toNewsEntity()
                    }
                ).andThen(
                    repository.insertNewsToDatabase(listResponse.map { itemResponse ->
                        itemResponse.toNewsEntity()
                    })
                )
            }.blockingAwait()
    }

    @Test
    override fun integration3() = benchmarkRule.measureRepeated {
        runWithTimingDisabled { localDataSource.deleteAllNews().blockingAwait() }
        remoteDataSource.getTopHeadlines()
            .flatMap { remoteDataSource.getTopHeadlines() }
            .flatMap { remoteDataSource.getTopHeadlines() }
            .flatMap { remoteDataSource.getTopHeadlines() }
            .flatMap { repository.getEverythingNews(List(10) { "us" }) }
            .flatMap { repository.getEverythingNews(List(10) { "us" }) }
            .flatMap { repository.getEverythingNews(List(10) { "us" }) }
            .flatMap { repository.getEverythingNews(List(10) { "us" }) }
            .flatMapCompletable { listResponse ->
                repository.insertNewsToDatabase(
                    listResponse.map { itemResponse ->
                        itemResponse.toNewsEntity()
                    }
                )
                    .andThen(repository.insertNewsToDatabase(listResponse.map { itemResponse -> itemResponse.toNewsEntity() }))
                    .andThen(repository.insertNewsToDatabase(listResponse.map { itemResponse -> itemResponse.toNewsEntity() }))
                    .andThen(repository.insertNewsToDatabase(listResponse.map { itemResponse -> itemResponse.toNewsEntity() }))
                    .andThen(Completable.complete())
            }.blockingAwait()
    }

    @Test
    override fun integration4() = benchmarkRule.measureRepeated {
        runWithTimingDisabled { localDataSource.deleteAllNews().blockingAwait() }
        remoteDataSource.getTopHeadlines()
            .flatMap { remoteDataSource.getTopHeadlines() }
            .flatMap { remoteDataSource.getTopHeadlines() }
            .flatMap { remoteDataSource.getTopHeadlines() }
            .flatMap { remoteDataSource.getTopHeadlines() }
            .flatMap { remoteDataSource.getTopHeadlines() }
            .flatMap { remoteDataSource.getTopHeadlines() }
            .flatMap { remoteDataSource.getTopHeadlines() }
            .flatMap { repository.getEverythingNews(List(10) { "us" }) }
            .flatMap { repository.getEverythingNews(List(10) { "us" }) }
            .flatMap { repository.getEverythingNews(List(10) { "us" }) }
            .flatMap { repository.getEverythingNews(List(10) { "us" }) }
            .flatMap { repository.getEverythingNews(List(10) { "us" }) }
            .flatMap { repository.getEverythingNews(List(10) { "us" }) }
            .flatMap { repository.getEverythingNews(List(10) { "us" }) }
            .flatMap { repository.getEverythingNews(List(10) { "us" }) }
            .flatMapCompletable { listResponse ->
                repository.insertNewsToDatabase(listResponse.map { itemResponse -> itemResponse.toNewsEntity() })
                    .andThen(repository.insertNewsToDatabase(listResponse.map { itemResponse -> itemResponse.toNewsEntity() }))
                    .andThen(repository.insertNewsToDatabase(listResponse.map { itemResponse -> itemResponse.toNewsEntity() }))
                    .andThen(repository.insertNewsToDatabase(listResponse.map { itemResponse -> itemResponse.toNewsEntity() }))
                    .andThen(repository.insertNewsToDatabase(listResponse.map { itemResponse -> itemResponse.toNewsEntity() }))
                    .andThen(repository.insertNewsToDatabase(listResponse.map { itemResponse -> itemResponse.toNewsEntity() }))
                    .andThen(repository.insertNewsToDatabase(listResponse.map { itemResponse -> itemResponse.toNewsEntity() }))
                    .andThen(repository.insertNewsToDatabase(listResponse.map { itemResponse -> itemResponse.toNewsEntity() }))
                    .andThen(Completable.complete())
            }.blockingAwait()
    }
}