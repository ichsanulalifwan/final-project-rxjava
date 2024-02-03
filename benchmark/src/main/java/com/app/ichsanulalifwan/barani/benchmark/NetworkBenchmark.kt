package com.app.ichsanulalifwan.barani.benchmark

import org.junit.Test

interface NetworkBenchmark {
    @Test
    fun fetchNewsSingleRequest()

    @Test
    fun fetchNewsThreeSequentialRequests()

    @Test
    fun fetchTwoNewsDetails()

    @Test
    fun fetchTenNewsDetails()

    @Test
    fun fetchTwentyNewsDetails()

    @Test
    fun fetchFiftyNewsDetails()
}