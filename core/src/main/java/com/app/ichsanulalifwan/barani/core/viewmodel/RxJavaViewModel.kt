package com.app.ichsanulalifwan.barani.core.viewmodel

import android.app.Application
import android.util.Log
import com.app.ichsanulalifwan.barani.core.R
import com.app.ichsanulalifwan.barani.core.data.location.getAddresses
import com.app.ichsanulalifwan.barani.core.data.location.getLocationUpdates
import com.app.ichsanulalifwan.barani.core.data.repository.location.AddressRepository
import com.app.ichsanulalifwan.barani.core.data.repository.news.NewsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RxJavaViewModel(
    application: Application,
    private val newsRepository: NewsRepository,
    private val addressRepository: AddressRepository,
) : BaseViewModel(application) {

    private val disposableBag = CompositeDisposable()
    private var locationDisposable: Disposable? = null

    init {
        getTopHeadlineNews()
        getNewsPublisher()
    }

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

    override fun startUpdatesForEverythingNews() {
        startEverythingNewsTimer()
        locationDisposable?.dispose()
        locationDisposable = getLocationUpdates(locationServiceClient, locationRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .flatMapSingle { location -> getAddresses(addressRepository, location, 1) }
            .flatMapCompletable { addresses ->
                val countryCode = addresses.first().countryCode
                newsRepository.getEverythingNews(countryCode).doOnComplete {
                    stopEverythingNewsTimer()
                    isLoading.postValue(false)
                    isLocalNews.postValue(true)
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { isLoading.value = true }
            .subscribe({}, { handleEverythingNewsError(it) })
            .also { disposableBag.add(it) }
    }

    override fun cancelUpdatesForEverythingNews() {
        locationDisposable?.dispose()
    }

    override fun getNewsPublisher() {
        startSourcesNewsTimer()
        newsRepository.getNewsPublisher()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { isLoading.value = true }
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
            ).also { disposableBag.add(it) }
    }

    override fun onCleared() {
        disposableBag.dispose()
        super.onCleared()
    }
}