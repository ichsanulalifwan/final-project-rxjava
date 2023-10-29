package com.app.ichsanulalifwan.barani.core.di

import android.app.Application
import com.app.ichsanulalifwan.barani.core.data.repository.news.NewsRepository
import com.app.ichsanulalifwan.barani.core.data.source.local.room.AppDatabase
import com.app.ichsanulalifwan.barani.core.data.source.remote.network.ApiConfig

object Injection {

    fun provideRepository(application: Application, isMock: Boolean): NewsRepository {

        val database = AppDatabase.getInstance(application.applicationContext)
        val newsDao = database.newsDao()
        val remoteDataSource = if (!isMock) {
            ApiConfig.getApiService()
        } else ApiConfig.getMockApiService()

        return NewsRepository.getInstance(remoteDataSource, newsDao)
    }
}