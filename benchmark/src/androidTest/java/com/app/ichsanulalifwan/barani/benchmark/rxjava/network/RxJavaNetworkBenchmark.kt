package com.app.ichsanulalifwan.barani.benchmark.rxjava.network

import androidx.benchmark.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.app.ichsanulalifwan.barani.benchmark.rxjava.RxJavaBenchmark
import com.app.ichsanulalifwan.barani.benchmark.NetworkBenchmark
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RxJavaNetworkBenchmark : RxJavaBenchmark(), NetworkBenchmark {

    @Test
    override fun fetchNewsSingleRequest() = benchmarkRule.measureRepeated {
        remoteDataSource.getNewsPublishers().blockingGet()
    }

    @Test
    override fun fetchNewsThreeSequentialRequests() = benchmarkRule.measureRepeated {
//        remoteDataSource.getTrendingNews()
//            .flatMap { remoteSource.getTrendingNews() }
//            .flatMap { remoteSource.getTrendingNews() }
//            .blockingGet()
    }

    @Test
    override fun fetchTwoNewsDetails() = benchmarkRule.measureRepeated {
        val newsIds = List(2) { 1 }
//        repository.getMoviesDetail(newsIds).blockingGet()
    }

    @Test
    override fun fetchTenNewsDetails() = benchmarkRule.measureRepeated {
        val newsIds = List(10) { 1 }
//        repository.getMoviesDetail(newsIds).blockingGet()
    }

    @Test
    override fun fetchTwentyNewsDetails() = benchmarkRule.measureRepeated {
        val newsIds = List(20) { 1 }
//        repository.getMoviesDetail(newsIds).blockingGet()
    }

    @Test
    override fun fetchFiftyNewsDetails() = benchmarkRule.measureRepeated {
        val newsIds = List(50) { 1 }
//        repository.getMoviesDetail(newsIds).blockingGet()
    }
}