package com.app.ichsanulalifwan.barani.core.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.ichsanulalifwan.barani.core.R
import com.app.ichsanulalifwan.barani.core.model.News
import com.app.ichsanulalifwan.barani.core.utils.NewsTimer
import com.app.ichsanulalifwan.barani.core.utils.throwable.LocationProviderNotAvailableException
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices

abstract class BaseViewModel(private val application: Application) : ViewModel(), NewsTimer {

    protected val locationServiceClient: FusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(application.applicationContext)
    }

    protected val locationRequest by lazy {
        LocationRequest().apply {
            interval = ONE_MINUTE
            fastestInterval = ONE_MINUTE
        }
    }


    /**
     * Timer
     */
    override var topHeadlineRunNumber: Int = 0
    override var everythingRunNumber: Int = 0
    override var sourcesRunNumber: Int = 0

    override var startTopHeadline: Long = 0
    override var startEverything: Long = 0
    override var startSources: Long = 0

    protected val message by lazy { MutableLiveData<String?>() }
    protected val isLoading by lazy { MutableLiveData<Boolean>().apply { value = false } }
    protected val isLocalNews by lazy { MutableLiveData<Boolean>().apply { value = false } }

    fun getMessage(): LiveData<String?> = message
    fun getIsLoading(): LiveData<Boolean> = isLoading

    abstract fun getNews(): LiveData<List<News>>
    protected abstract fun getTopHeadlineNews()
    protected abstract fun getNewsPublisher()
    protected abstract fun startUpdatesForEverythingNews()
    protected abstract fun cancelUpdatesForEverythingNews()

    protected val context: Context
        get() = application.applicationContext

    fun resetMessage() {
        message.value = null
    }

    fun onLocationPermissionDeniedIndefinitely() {
        message.value = application.applicationContext.getString(R.string.location_permission_denied)
    }

    protected fun handleEverythingNewsError(it: Throwable?) {
        startUpdatesForEverythingNews()
        message.value = if (it is LocationProviderNotAvailableException) {
            context.getString(R.string.location_provider_off)
        } else {
            context.getString(R.string.news_error)
        }

        isLoading.value = false
        isLocalNews.value = false
        cancelUpdatesForEverythingNews()
        getTopHeadlineNews()
    }

    companion object {
        const val LOG_TAG = "ViewModel"
        const val ONE_MINUTE = 60000L
    }
}