package com.app.ichsanulalifwan.barani.benchmark.rxjava.integration

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.app.ichsanulalifwan.barani.benchmark.IntegrationBenchmark
import com.app.ichsanulalifwan.barani.benchmark.rxjava.RxJavaBenchmark
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RxJavaIntegrationBenchmark : RxJavaBenchmark(), IntegrationBenchmark {

    //    @Test
//    override fun integration_1() = benchmarkRule.measureRepeated {
//        runWithTimingDisabled { localSource.nukeAsCompletable().blockingAwait() }
//        remoteSource.getTrendingNews()
//            .flatMap { repository.getMoviesDetail(List(20) { it }) }
//            .flatMapCompletable { repository.insertMoviesToDatabase(it.mapNotNull { movieDetails -> movieDetails.toEntity() }) }
//            .blockingAwait()
//    }
//
//    @Test
//    override fun integration_2() = benchmarkRule.measureRepeated {
//        runWithTimingDisabled { localSource.nukeAsCompletable().blockingAwait() }
//        remoteSource.getTrendingNews()
//            .flatMap { remoteSource.getTrendingNews() }
//            .flatMap { repository.getMoviesDetail(List(20) { it }) }
//            .flatMap { repository.getMoviesDetail(List(20) { it }) }
//            .flatMapCompletable {
//                repository.insertMoviesToDatabase(it.mapNotNull { movieDetails -> movieDetails.toEntity() })
//                    .andThen(repository.insertMoviesToDatabase(it.mapNotNull { movieDetails -> movieDetails.toEntity() }))
//            }.blockingAwait()
//    }
//
//    @Test
//    override fun integration_3() = benchmarkRule.measureRepeated {
//        runWithTimingDisabled { localSource.nukeAsCompletable().blockingAwait() }
//        remoteSource.getTrendingNews()
//            .flatMap { remoteSource.getTrendingNews() }
//            .flatMap { remoteSource.getTrendingNews() }
//            .flatMap { repository.getMoviesDetail(List(20) { it }) }
//            .flatMap { repository.getMoviesDetail(List(20) { it }) }
//            .flatMap { repository.getMoviesDetail(List(20) { it }) }
//            .flatMapCompletable {
//                repository.insertMoviesToDatabase(it.mapNotNull { movieDetails -> movieDetails.toEntity() })
//                    .andThen(repository.insertMoviesToDatabase(it.mapNotNull { movieDetails -> movieDetails.toEntity() }))
//                    .andThen(repository.insertMoviesToDatabase(it.mapNotNull { movieDetails -> movieDetails.toEntity() }))
//                    .andThen(Completable.complete())
//            }.blockingAwait()
//    }
//
//    @Test
//    override fun integration_4() = benchmarkRule.measureRepeated {
//        runWithTimingDisabled { localSource.nukeAsCompletable().blockingAwait() }
//        remoteSource.getTrendingNews()
//            .flatMap { remoteSource.getTrendingNews() }
//            .flatMap { remoteSource.getTrendingNews() }
//            .flatMap { remoteSource.getTrendingNews() }
//            .flatMap { repository.getMoviesDetail(List(20) { it }) }
//            .flatMap { repository.getMoviesDetail(List(20) { it }) }
//            .flatMap { repository.getMoviesDetail(List(20) { it }) }
//            .flatMap { repository.getMoviesDetail(List(20) { it }) }
//            .flatMapCompletable {
//                repository.insertMoviesToDatabase(it.mapNotNull { movieDetails -> movieDetails.toEntity() })
//                    .andThen(repository.insertMoviesToDatabase(it.mapNotNull { movieDetails -> movieDetails.toEntity() }))
//                    .andThen(repository.insertMoviesToDatabase(it.mapNotNull { movieDetails -> movieDetails.toEntity() }))
//                    .andThen(repository.insertMoviesToDatabase(it.mapNotNull { movieDetails -> movieDetails.toEntity() }))
//                    .andThen(Completable.complete())
//            }.blockingAwait()
//    }
//
//    @Test
//    override fun integration_reactive() = benchmarkRule.measureRepeated {
//
//        val flowable = Flowable.create<MovieResponse>({ emitter ->
//            emitter.onNext(remoteSource.getTrendingNews().blockingGet())
//        }, BackpressureStrategy.LATEST)
//            .flatMapSingle { remoteSource.getNewsForRegion("PT") }
//            .subscribeOn(Schedulers.io())
//
//        flowable.blockingFirst()
//    }
    override fun integration_1() {
        TODO("Not yet implemented")
    }

    override fun integration_2() {
        TODO("Not yet implemented")
    }

    override fun integration_3() {
        TODO("Not yet implemented")
    }

    override fun integration_4() {
        TODO("Not yet implemented")
    }

    override fun integration_reactive() {
        TODO("Not yet implemented")
    }
}