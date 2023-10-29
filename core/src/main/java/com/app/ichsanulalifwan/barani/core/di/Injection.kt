package com.app.ichsanulalifwan.barani.core.di

import android.app.Application
import com.app.ichsanulalifwan.barani.core.data.repository.news.NewsRepository
import com.app.ichsanulalifwan.barani.core.data.source.local.room.AppDatabase

object Injection {

    fun provideRepository(application: Application): NewsRepository {

        val database = AppDatabase.getInstance(application.applicationContext)
        val newsDao = database.newsDao()

        return NewsRepository.getInstance(newsDao)
    }
}