package com.app.ichsanulalifwan.barani.benchmark.api

import org.junit.Test

interface DatabaseBenchmark {

    /**
     * Inserts
     */
    @Test
    fun insertTwoNews()

    @Test
    fun insertTenNews()

    @Test
    fun insertTwentyNews()

    @Test
    fun insertFiftyNews()

    @Test
    fun insertOneHundredNews()

    @Test
    fun clearAndInsertTwentyNews()

    /**
     * Queries
     */
    @Test
    fun queryTwentyNews()

    @Test
    fun queryFiftyNews()

    @Test
    fun queryOneHundredNews()

    @Test
    fun queryTwentyNewsInParallel()
}