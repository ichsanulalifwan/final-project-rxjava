package com.app.ichsanulalifwan.barani.ui.beranda

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.toLiveData
import com.app.ichsanulalifwan.barani.core.R
import com.app.ichsanulalifwan.barani.core.data.repository.news.NewsRepository
import com.app.ichsanulalifwan.barani.core.model.News
import com.app.ichsanulalifwan.barani.core.utils.DataMapper
import com.app.ichsanulalifwan.barani.core.viewmodel.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class BerandaViewModel(
    application: Application,
    private val newsRepository: NewsRepository,
) : BaseViewModel(application) {

    private val disposableBag = CompositeDisposable()

    init {
        getTopHeadlineNews()
    }

    override fun getNews(): LiveData<List<News>> = newsRepository.news
        .map { entityList ->
            DataMapper.mapNewsEntityToModel(entityList)
        }
        .subscribeOn(Schedulers.io())
        .toLiveData()

    override fun getTopHeadlineNews() {
        startTopHeadlinesNewsTimer()
        newsRepository.getTopHeadlineNews("us", "health")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { isLoading.value = true }
            .doFinally {
                stopTopHeadlinesNewsTimer()
                isLoading.value = false
            }
            .subscribe(
                { isLocalNews.value = false },
                { throwable ->
                    message.value = context.getString(R.string.news_error)
                    Log.e(LOG_TAG, "Could not fetch news", throwable)
                }
            ).also { disposableBag.add(it) }
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