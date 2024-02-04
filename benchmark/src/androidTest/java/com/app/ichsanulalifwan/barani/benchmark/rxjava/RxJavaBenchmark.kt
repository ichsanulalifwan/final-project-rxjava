package com.app.ichsanulalifwan.barani.benchmark.rxjava

import android.content.Context
import androidx.benchmark.junit4.BenchmarkRule
import androidx.test.platform.app.InstrumentationRegistry
import com.app.ichsanulalifwan.barani.core.data.repository.news.NewsRepository
import com.app.ichsanulalifwan.barani.core.data.source.local.room.AppDatabase
import com.app.ichsanulalifwan.barani.core.data.source.remote.network.ApiConfig
import org.junit.Rule

open class RxJavaBenchmark {

    @Rule
    val benchmarkRule = BenchmarkRule()

    private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext
    protected val remoteDataSource = ApiConfig.getMockApiService()
    protected val localDataSource = AppDatabase.getInstance(context).newsDao()
    protected val repository = NewsRepository(remoteDataSource, localDataSource)
}