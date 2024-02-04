package com.app.ichsanulalifwan.barani.core.viewmodel.reactor

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.toLiveData
import com.app.ichsanulalifwan.barani.core.R
import com.app.ichsanulalifwan.barani.core.data.location.reactor.getAddresses
import com.app.ichsanulalifwan.barani.core.data.location.reactor.getLocationUpdates
import com.app.ichsanulalifwan.barani.core.data.repository.location.AddressRepository
import com.app.ichsanulalifwan.barani.core.data.repository.news.reactor.ReactorNewsRepository
import com.app.ichsanulalifwan.barani.core.model.News
import com.app.ichsanulalifwan.barani.core.model.Publisher
import com.app.ichsanulalifwan.barani.core.utils.DataMapper
import com.app.ichsanulalifwan.barani.core.viewmodel.BaseViewModel
import reactor.core.Disposable
import reactor.core.Disposables
import reactor.core.scheduler.Schedulers

class ReactorViewModel(
    application: Application,
    private val newsRepository: ReactorNewsRepository,
    private val addressRepository: AddressRepository,
) : BaseViewModel(application) {

    private val disposable = Disposables.composite()
    private var locationDisposable: Disposable? = null

    init {
        getTopHeadlineNews()
        getNewsPublisher()
    }

    override fun getNews(): LiveData<List<News>> = TODO()
//    newsRepository.news
//        .map { entityList ->
//            DataMapper.mapNewsEntityToModel(entityList)
//        }
//        .toLiveData()

    override fun getPublishers(): LiveData<List<Publisher>> = TODO()
//        newsRepository.publishers
//        .map { entityList ->
//            DataMapper.mapPublisherListToModel(entityList)
//        }
//        .toLiveData()

    override fun getTopHeadlineNews() {
        startTopHeadlinesNewsTimer()

        newsRepository.getTopHeadlineNews(countryCode = "us", category = "health")
            .subscribeOn(Schedulers.boundedElastic())
            .publishOn(Schedulers.single())
            .doOnSubscribe {
                isLoading.value = true
            }
            .doFinally {
                stopTopHeadlinesNewsTimer()
                isLoading.value = false
            }
            .doOnSuccess { isLocalNews.value = false }
            .doOnError { throwable ->
                message.value = context.getString(R.string.news_error)
                Log.e(LOG_TAG, "Could not fetch news", throwable)
            }
            .subscribe()
            .also {
                disposable.add(it)
            }
    }

    override fun startUpdatesForEverythingNews() {
        startEverythingNewsTimer()

        locationDisposable?.dispose()
        locationDisposable = getLocationUpdates(
            locationServiceClient = locationServiceClient,
            locationRequest = locationRequest,
        )
            .subscribeOn(Schedulers.boundedElastic())
            .publishOn(Schedulers.boundedElastic())
            .flatMap { location ->
                getAddresses(
                    addressRepository = addressRepository,
                    location = location,
                    maxResults = 1,
                ).flatMap { addresses ->
                    val countryCode = addresses.first().countryCode
                    newsRepository.getEverythingNews(countryCode = countryCode)
                        .doFinally {
                            stopEverythingNewsTimer()
                            isLoading.postValue(false)
                            isLocalNews.postValue(true)
                        }
                }
            }
            .publishOn(Schedulers.single())
            .doOnSubscribe { isLoading.value = true }
            .subscribe({}, {
                handleEverythingNewsError(it)
            })
            .also {
                disposable.add(it)
            }
    }

    override fun cancelUpdatesForEverythingNews() {
        locationDisposable?.dispose()
    }

    override fun getNewsPublisher() {
        startSourcesNewsTimer()

        newsRepository.getNewsPublisher()
            .subscribeOn(Schedulers.boundedElastic())
            .publishOn(Schedulers.single())
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
            )
            .also {
                disposable.add(it)
            }
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}