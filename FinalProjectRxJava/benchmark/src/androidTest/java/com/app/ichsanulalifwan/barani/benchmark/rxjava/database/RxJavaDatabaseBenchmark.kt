package com.app.ichsanulalifwan.barani.benchmark.rxjava.database

import android.annotation.SuppressLint
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.app.ichsanulalifwan.barani.benchmark.api.DatabaseBenchmark
import com.app.ichsanulalifwan.barani.benchmark.mock.getMockNewsEntity
import com.app.ichsanulalifwan.barani.benchmark.rxjava.RxJavaBenchmark
import org.junit.Test
import org.junit.runner.RunWith

@SuppressLint("CheckResult")
@RunWith(AndroidJUnit4::class)
class RxJavaDatabaseBenchmark : RxJavaBenchmark(), DatabaseBenchmark {

    @Test
    override fun queryOneNews() = benchmarkRule.measureRepeated {
        runWithTimingDisabled {
            clearAndInsertMovies(size = 1)
        }
        repository.news.blockingFirst()
    }

    @Test
    override fun queryFiveNews() = benchmarkRule.measureRepeated {
        runWithTimingDisabled {
            clearAndInsertMovies(size = 5)
        }
        repository.news.blockingFirst()
    }

    @Test
    override fun queryTenNews() = benchmarkRule.measureRepeated {
        runWithTimingDisabled {
            clearAndInsertMovies(size = 10)
        }
        repository.news.blockingFirst()
    }

    @Test
    override fun queryTwentyFiveNews() = benchmarkRule.measureRepeated {
        runWithTimingDisabled {
            clearAndInsertMovies(size = 25)
        }
        repository.news.blockingFirst()
    }

    @Test
    override fun queryFiftyNews() = benchmarkRule.measureRepeated {
        runWithTimingDisabled {
            clearAndInsertMovies(size = 50)
        }
        repository.news.blockingFirst()
    }

    @Test
    override fun queryOneHundredNews() = benchmarkRule.measureRepeated {
        runWithTimingDisabled {
            clearAndInsertMovies(size = 100)
        }
        repository.news.blockingFirst()
    }

    private fun clearAndInsertMovies(size: Int) {
        val listToInsert = List(size) {
            getMockNewsEntity(it)
        }
        repository.insertNewsToDatabase(listToInsert).blockingAwait()
    }
}