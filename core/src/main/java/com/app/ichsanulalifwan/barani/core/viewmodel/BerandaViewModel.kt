package com.app.ichsanulalifwan.barani.core.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.ichsanulalifwan.barani.core.BuildConfig
import com.app.ichsanulalifwan.barani.core.data.remote.network.ApiConfig
import com.app.ichsanulalifwan.barani.core.model.ArticlesItem
import com.app.ichsanulalifwan.barani.core.model.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BerandaViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun getLatestNews(): LiveData<List<ArticlesItem>> {
        _isLoading.value = true
        val news = MutableLiveData<List<ArticlesItem>>()
        ApiConfig.provideApiService().getNews("id", "health", API_KEY)
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful) {
                        news.value = response.body()?.articles as List<ArticlesItem>
                        _isLoading.value = false
                    } else {
                        Log.e(TAG, "onFailure: ${response.message()}")
                        _isLoading.value = false
                    }
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e(TAG, "onFailure: ${t.message.toString()}")
                    _isLoading.value = false
                }
            })
        return news
    }

    companion object {
        private const val API_KEY = BuildConfig.API_KEY
        private const val TAG = "BerandaViewModel"
    }
}