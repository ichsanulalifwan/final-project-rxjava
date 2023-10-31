package com.app.ichsanulalifwan.barani.ui.beranda

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.toLiveData
import com.app.ichsanulalifwan.barani.core.data.repository.news.NewsRepository
import com.app.ichsanulalifwan.barani.core.model.News
import com.app.ichsanulalifwan.barani.core.utils.DataMapper
import com.app.ichsanulalifwan.barani.core.viewmodel.BaseViewModel
import io.reactivex.schedulers.Schedulers

class BerandaViewModel(
    application: Application,
    private val newsRepository: NewsRepository,
) : BaseViewModel(application) {

    override fun getNews(): LiveData<List<News>> = newsRepository.news
        .map { entityList ->
            DataMapper.mapNewsEntityToModel(entityList)
        }
        .subscribeOn(Schedulers.io())
        .toLiveData()

    override fun getTopHeadlineNews() {
        TODO("Not yet implemented")
    }

    override fun getNewsPublisher() {
        TODO("Not yet implemented")
    }

    override fun startUpdatesForEverythingNews() {
        TODO("Not yet implemented")
    }

    override fun cancelUpdatesForEverythingNews() {
        TODO("Not yet implemented")
    }
}