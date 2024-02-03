package com.app.ichsanulalifwan.barani.benchmark.rxjava.database

import androidx.benchmark.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.app.ichsanulalifwan.barani.benchmark.DatabaseBenchmark
import com.app.ichsanulalifwan.barani.benchmark.mock.getMockEntity
import com.app.ichsanulalifwan.barani.benchmark.rxjava.RxJavaBenchmark
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RxJavaDatabaseBenchmark : RxJavaBenchmark(), DatabaseBenchmark {

    /**
     * Inserts
     */

    @Test
    override fun insert_two_news() = benchmarkRule.measureRepeated {
        runWithTimingDisabled { localDataSource.deleteNewsAsCompletable().blockingAwait() }
        val entities = List(2) { getMockEntity(it) }
        localDataSource.insertNewsAsCompletable(entities).blockingAwait()
    }

    @Test
    override fun insert_ten_news() = benchmarkRule.measureRepeated {
        runWithTimingDisabled { localDataSource.deleteNewsAsCompletable().blockingAwait() }
        val entities = List(10) { getMockEntity(it) }
        localDataSource.insertNewsAsCompletable(entities).blockingAwait()
    }

    @Test
    override fun insert_twenty_news() = benchmarkRule.measureRepeated {
        runWithTimingDisabled { localDataSource.deleteNewsAsCompletable().blockingAwait() }
        val entities = List(20) { getMockEntity(it) }
        localDataSource.insertNewsAsCompletable(entities).blockingAwait()
    }

    @Test
    override fun insert_fifty_news() = benchmarkRule.measureRepeated {
        runWithTimingDisabled { localDataSource.deleteNewsAsCompletable().blockingAwait() }
        val entities = List(50) { getMockEntity(it) }
        localDataSource.insertNewsAsCompletable(entities).blockingAwait()
    }

    @Test
    override fun insert_one_hundred_news() = benchmarkRule.measureRepeated {
        runWithTimingDisabled { localDataSource.deleteNewsAsCompletable().blockingAwait() }
        val entities = List(100) { getMockEntity(it) }
        localDataSource.insertNewsAsCompletable(entities).blockingAwait()
    }

    @Test
    override fun clear_and_insert_twenty_news() = benchmarkRule.measureRepeated {
        clearAndInsertMovies(20)
    }

    /**
     * Queries
     */

    @Test
    override fun query_twenty_news() = benchmarkRule.measureRepeated {
        runWithTimingDisabled { clearAndInsertMovies(size = 20) }
        localDataSource.allNewsBySingle().blockingGet()
    }

    @Test
    override fun query_fifty_news() = benchmarkRule.measureRepeated {
        runWithTimingDisabled { clearAndInsertMovies(size = 50) }
        localDataSource.allNewsBySingle().blockingGet()
    }

    @Test
    override fun query_one_hundred_news() = benchmarkRule.measureRepeated {
        runWithTimingDisabled { clearAndInsertMovies(size = 100) }
        localDataSource.allNewsBySingle().blockingGet()
    }

    @Test
    override fun query_twenty_news_in_parallel() = benchmarkRule.measureRepeated {

        runWithTimingDisabled { clearAndInsertMovies(20) }

        val singlesToZip = List(20) { localDataSource.allNewsBySingle().subscribeOn(Schedulers.io()) }
        Single.zip(singlesToZip) { it.toList() }.blockingGet()
    }

    @Test
    override fun query_twenty_news_reactive() = benchmarkRule.measureRepeated {
        runWithTimingDisabled { clearAndInsertMovies(20) }
        localDataSource.allNewsByFlowable().blockingFirst()
    }

    private fun clearAndInsertMovies(size: Int) {
        val listToInsert = List(size) { getMockEntity(it) }
        repository.insertNewsToDatabase(listToInsert).blockingAwait()
    }
}