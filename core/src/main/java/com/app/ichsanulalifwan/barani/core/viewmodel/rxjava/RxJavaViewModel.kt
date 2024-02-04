package com.app.ichsanulalifwan.barani.core.viewmodel.rxjava

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.toLiveData
import com.app.ichsanulalifwan.barani.core.R
import com.app.ichsanulalifwan.barani.core.data.location.rxJava.getAddresses
import com.app.ichsanulalifwan.barani.core.data.location.rxJava.getLocationUpdates
import com.app.ichsanulalifwan.barani.core.data.repository.location.AddressRepository
import com.app.ichsanulalifwan.barani.core.data.repository.news.rxjava.RxJavaNewsRepository
import com.app.ichsanulalifwan.barani.core.model.News
import com.app.ichsanulalifwan.barani.core.model.Publisher
import com.app.ichsanulalifwan.barani.core.utils.DataMapper
import com.app.ichsanulalifwan.barani.core.viewmodel.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RxJavaViewModel(
    application: Application,
    private val newsRepository: RxJavaNewsRepository,
    private val addressRepository: AddressRepository,
) : BaseViewModel(application) {

    private val disposableBag = CompositeDisposable()
    private var locationDisposable: Disposable? = null

    init {
        getTopHeadlineNews()
        getNewsPublisher()
    }

    override fun getNews(): LiveData<List<News>> = newsRepository.news
        .map { entityList ->
            DataMapper.mapNewsEntityToModel(entityList)
        }
        .subscribeOn(Schedulers.io())
        .toLiveData()

    override fun getPublishers(): LiveData<List<Publisher>> = newsRepository.publishers
        .map { entityList ->
            DataMapper.mapPublisherListToModel(entityList)
        }
        .subscribeOn(Schedulers.io())
        .toLiveData()

    override fun getTopHeadlineNews() {
        startTopHeadlinesNewsTimer()

        newsRepository.getTopHeadlineNews(countryCode = "us", category = "health")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                isLoading.value = true
            }
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
            ).also {
                disposableBag.add(it)
            }
    }

    override fun startUpdatesForEverythingNews() {
        startEverythingNewsTimer()

        locationDisposable?.dispose()
        locationDisposable = getLocationUpdates(
            locationServiceClient = locationServiceClient,
            locationRequest = locationRequest,
        )
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .flatMapSingle { location ->
                getAddresses(
                    addressRepository = addressRepository,
                    location = location,
                    maxResults = 1,
                )
            }
            .flatMapCompletable { addresses ->
                val countryCode = addresses.first().countryCode
                newsRepository.getEverythingNews(countryCode = countryCode).doOnComplete {
                    stopEverythingNewsTimer()
                    isLoading.postValue(false)
                    isLocalNews.postValue(true)
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                isLoading.value = true
            }
            .subscribe({}, {
                handleEverythingNewsError(it)
            })
            .also {
                disposableBag.add(it)
            }
    }

    override fun cancelUpdatesForEverythingNews() {
        locationDisposable?.dispose()
    }

    override fun getNewsPublisher() {
        startSourcesNewsTimer()

        newsRepository.getNewsPublisher()
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

    override fun onCleared() {
        disposableBag.dispose()
        super.onCleared()
    }
}