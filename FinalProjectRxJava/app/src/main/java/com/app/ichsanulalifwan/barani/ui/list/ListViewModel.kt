package com.app.ichsanulalifwan.barani.ui.list

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.toLiveData
import com.app.ichsanulalifwan.barani.core.R
import com.app.ichsanulalifwan.barani.core.data.repository.location.AddressRepository
import com.app.ichsanulalifwan.barani.core.data.repository.news.rxjava.RxJavaNewsRepository
import com.app.ichsanulalifwan.barani.core.model.News
import com.app.ichsanulalifwan.barani.core.model.Publisher
import com.app.ichsanulalifwan.barani.core.utils.DataMapper
import com.app.ichsanulalifwan.barani.core.viewmodel.BaseViewModel
import com.app.ichsanulalifwan.barani.utils.Constant.HEALTH_CATEGORY
import com.app.ichsanulalifwan.barani.utils.Constant.US_COUNTRY_CODE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ListViewModel(
    application: Application,
    private val rxJavaNewsRepository: RxJavaNewsRepository,
    private val addressRepository: AddressRepository,
) : BaseViewModel(application) {

    private val disposableBag = CompositeDisposable()
    private var locationDisposable: Disposable? = null

    init {
        getTopHeadlineNews()
    }

    override fun getNews(): LiveData<List<News>> = rxJavaNewsRepository.news
        .map { entityList ->
            DataMapper.mapNewsEntityToModel(entityList)
        }
        .subscribeOn(Schedulers.io())
        .toLiveData()

    override fun getPublishers(): LiveData<List<Publisher>> = rxJavaNewsRepository.publishers
        .map { entityList ->
            DataMapper.mapPublisherListToModel(entityList)
        }
        .subscribeOn(Schedulers.io())
        .toLiveData()

    override fun getTopHeadlineNews() {
        startTopHeadlinesNewsTimer()
        rxJavaNewsRepository.getTopHeadlineNews(US_COUNTRY_CODE, HEALTH_CATEGORY)
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
        startSourcesNewsTimer()

        rxJavaNewsRepository.getNewsPublisher()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                isLoading.value = true
            }
            .doFinally {
                stopSourcesNewsTimer()
                isLoading.value = false
            }
            .subscribe(
                { isLocalNews.value = false },
                { throwable ->
                    message.value = context.getString(R.string.news_error)
                    Log.e(LOG_TAG, "Could not fetch publisher", throwable)
                }
            )
            .also {
                disposableBag.add(it)
            }
    }

    override fun startUpdatesForTopHeadlineNewsLocal() {
        TODO("Not yet implemented")
    }

    override fun cancelUpdatesForTopHeadlineNewsLocal() {
        locationDisposable?.dispose()
    }

    override fun onCleared() {
        disposableBag.dispose()
        super.onCleared()
    }
}