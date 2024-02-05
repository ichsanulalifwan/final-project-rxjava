package com.app.ichsanulalifwan.barani.benchmark.api

import org.junit.Test

interface NetworkBenchmark {
    @Test
    fun fetchNewsSingleRequest()

    @Test
    fun fetchNewsThreeSequentialRequests()

    @Test
    fun fetchTwoNews()

    @Test
    fun fetchTenNews()

    @Test
    fun fetchTwentyNews()

    @Test
    fun fetchFiftyNews()
}