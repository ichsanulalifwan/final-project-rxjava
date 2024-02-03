package com.app.ichsanulalifwan.barani.benchmark

import org.junit.Test

interface DatabaseBenchmark {
    /**
     * Inserts
     */

    @Test
    fun insert_two_news()

    @Test
    fun insert_ten_news()

    @Test
    fun insert_twenty_news()

    @Test
    fun insert_fifty_news()

    @Test
    fun insert_one_hundred_news()

    @Test
    fun clear_and_insert_twenty_news()

    /**
     * Queries
     */

    @Test
    fun query_twenty_news()

    @Test
    fun query_fifty_news()

    @Test
    fun query_one_hundred_news()

    @Test
    fun query_twenty_news_in_parallel()

    @Test
    fun query_twenty_news_reactive()
}