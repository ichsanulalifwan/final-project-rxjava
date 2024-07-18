package com.app.ichsanulalifwan.barani.benchmark.rxjava

import android.content.Context
import androidx.benchmark.junit4.BenchmarkRule
import androidx.test.platform.app.InstrumentationRegistry
import com.app.ichsanulalifwan.barani.core.data.repository.news.rxjava.RxJavaNewsRepository
import com.app.ichsanulalifwan.barani.core.data.source.local.room.AppDatabase
import com.app.ichsanulalifwan.barani.core.data.source.local.room.NewsDao
import com.app.ichsanulalifwan.barani.core.data.source.remote.network.ApiConfig
import com.app.ichsanulalifwan.barani.core.data.source.remote.network.rxjava.RxJavaNewsApiService
import org.junit.Rule

open class RxJavaBenchmark {

    protected val remoteDataSource: RxJavaNewsApiService by lazy {
        ApiConfig.getMockApiService(context = context)
    }

    protected val localDataSource: NewsDao by lazy {
        AppDatabase.getInstance(context = context).newsDao()
    }

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext
    protected val repository = RxJavaNewsRepository(
        remoteDataSource = remoteDataSource,
        localDataSource = localDataSource,
    )
}