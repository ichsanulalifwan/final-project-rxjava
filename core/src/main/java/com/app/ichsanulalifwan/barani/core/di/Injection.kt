package com.app.ichsanulalifwan.barani.core.di

import android.content.Context
import com.app.ichsanulalifwan.barani.core.data.repository.news.rxjava.RxJavaNewsRepository
import com.app.ichsanulalifwan.barani.core.data.source.local.room.AppDatabase
import com.app.ichsanulalifwan.barani.core.data.source.remote.network.ApiConfig

object Injection {

    fun provideRepository(context: Context, isMock: Boolean): RxJavaNewsRepository {

        val database = AppDatabase.getInstance(context.applicationContext)
        val newsDao = database.newsDao()
        val remoteDataSource = if (!isMock) {
            ApiConfig.getApiService()
        } else ApiConfig.getMockApiService()

        return RxJavaNewsRepository.getInstance(remoteDataSource, newsDao)
    }
}