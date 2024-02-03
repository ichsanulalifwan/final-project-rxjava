package com.app.ichsanulalifwan.barani.benchmark

import org.junit.Test

interface NetworkBenchmark {
    @Test
    fun fetch_news_single_request()

    @Test
    fun fetch_news_three_sequential_requests()

    @Test
    fun fetch_two_news_details()

    @Test
    fun fetch_ten_news_details()

    @Test
    fun fetch_twenty_news_details()

    @Test
    fun fetch_fifty_news_details()
}