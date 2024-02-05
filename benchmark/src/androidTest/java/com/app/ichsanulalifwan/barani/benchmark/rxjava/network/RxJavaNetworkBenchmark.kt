package com.app.ichsanulalifwan.barani.benchmark.rxjava.network

import android.annotation.SuppressLint
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.app.ichsanulalifwan.barani.benchmark.api.NetworkBenchmark
import com.app.ichsanulalifwan.barani.benchmark.rxjava.RxJavaBenchmark
import org.junit.Test
import org.junit.runner.RunWith

@SuppressLint("CheckResult")
@RunWith(AndroidJUnit4::class)
class RxJavaNetworkBenchmark : RxJavaBenchmark(), NetworkBenchmark {

    @Test
    override fun fetchNewsSingleRequest() = benchmarkRule.measureRepeated {
        remoteDataSource.getTopHeadlines().blockingGet()
    }

    @Test
    override fun fetchNewsThreeSequentialRequests() = benchmarkRule.measureRepeated {
        remoteDataSource.getTopHeadlines()
            .flatMap { remoteDataSource.getTopHeadlines() }
            .flatMap { remoteDataSource.getTopHeadlines() }
            .blockingGet()
    }

    @Test
    override fun fetchTwoNews() = benchmarkRule.measureRepeated {
        val countryCode = List(2) { "us" }
        repository.getEverythingNews(countryCode).blockingGet()
    }

    @Test
    override fun fetchTenNews() = benchmarkRule.measureRepeated {
        val newsIds = List(10) { "us" }
        repository.getEverythingNews(newsIds).blockingGet()
    }

    @Test
    override fun fetchTwentyNews() = benchmarkRule.measureRepeated {
        val newsIds = List(20) { "us" }
        repository.getEverythingNews(newsIds).blockingGet()
    }

    @Test
    override fun fetchFiftyNews() = benchmarkRule.measureRepeated {
        val newsIds = List(50) { "us" }
        repository.getEverythingNews(newsIds).blockingGet()
    }
}