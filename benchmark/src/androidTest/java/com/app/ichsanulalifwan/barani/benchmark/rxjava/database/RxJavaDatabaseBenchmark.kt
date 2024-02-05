package com.app.ichsanulalifwan.barani.benchmark.rxjava.database

import android.annotation.SuppressLint
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.app.ichsanulalifwan.barani.benchmark.api.DatabaseBenchmark
import com.app.ichsanulalifwan.barani.benchmark.mock.getMockNewsEntity
import com.app.ichsanulalifwan.barani.benchmark.rxjava.RxJavaBenchmark
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import org.junit.Test
import org.junit.runner.RunWith

@SuppressLint("CheckResult")
@RunWith(AndroidJUnit4::class)
class RxJavaDatabaseBenchmark : RxJavaBenchmark(), DatabaseBenchmark {

    /**
     * Inserts
     */
    @Test
    override fun insertTwoNews() = benchmarkRule.measureRepeated {
        runWithTimingDisabled {
            localDataSource.deleteNewsAsCompletable().blockingAwait()
        }
        val entities = List(2) {
            getMockNewsEntity(it)
        }
        localDataSource.insertNewsAsCompletable(entities).blockingAwait()
    }

    @Test
    override fun insertTenNews() = benchmarkRule.measureRepeated {
        runWithTimingDisabled {
            localDataSource.deleteNewsAsCompletable().blockingAwait()
        }
        val entities = List(10) {
            getMockNewsEntity(it)
        }
        localDataSource.insertNewsAsCompletable(entities).blockingAwait()
    }

    @Test
    override fun insertTwentyNews() = benchmarkRule.measureRepeated {
        runWithTimingDisabled {
            localDataSource.deleteNewsAsCompletable().blockingAwait()
        }
        val entities = List(20) {
            getMockNewsEntity(it)
        }
        localDataSource.insertNewsAsCompletable(entities).blockingAwait()
    }

    @Test
    override fun insertFiftyNews() = benchmarkRule.measureRepeated {
        runWithTimingDisabled {
            localDataSource.deleteNewsAsCompletable().blockingAwait()
        }
        val entities = List(50) {
            getMockNewsEntity(it)
        }
        localDataSource.insertNewsAsCompletable(entities).blockingAwait()
    }

    @Test
    override fun insertOneHundredNews() = benchmarkRule.measureRepeated {
        runWithTimingDisabled {
            localDataSource.deleteNewsAsCompletable().blockingAwait()
        }
        val entities = List(100) {
            getMockNewsEntity(it)
        }
        localDataSource.insertNewsAsCompletable(entities).blockingAwait()
    }

    @Test
    override fun clearAndInsertTwentyNews() = benchmarkRule.measureRepeated {
        clearAndInsertMovies(20)
    }

    /**
     * Queries
     */
    @Test
    override fun queryTwentyNews() = benchmarkRule.measureRepeated {
        runWithTimingDisabled {
            clearAndInsertMovies(size = 20)
        }
        localDataSource.allNewsByFlowable().blockingFirst()
    }

    @Test
    override fun queryFiftyNews() = benchmarkRule.measureRepeated {
        runWithTimingDisabled {
            clearAndInsertMovies(size = 50)
        }
        localDataSource.allNewsByFlowable().blockingFirst()
    }

    @Test
    override fun queryOneHundredNews() = benchmarkRule.measureRepeated {
        runWithTimingDisabled {
            clearAndInsertMovies(size = 100)
        }
        localDataSource.allNewsByFlowable().blockingFirst()
    }

    @Test
    override fun queryTwentyNewsInParallel() = benchmarkRule.measureRepeated {
        runWithTimingDisabled {
            clearAndInsertMovies(20)
        }
        val singlesToZip = List(20) {
            localDataSource.allNewsByFlowable().subscribeOn(Schedulers.io())
        }
        Flowable.zip(singlesToZip) { it.toList() }.blockingFirst()
    }

    private fun clearAndInsertMovies(size: Int) {
        val listToInsert = List(size) {
            getMockNewsEntity(it)
        }
        repository.insertNewsToDatabase(listToInsert).blockingAwait()
    }
}