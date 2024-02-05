package com.app.ichsanulalifwan.barani.core.mock

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response

class MockInterceptor(private val context: Context, private val sleepDurationMillis: Long = 50) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = Thread.sleep(sleepDurationMillis).run {
        chain.request().getMockedResponse(context = context)
    }
}