package com.app.ichsanulalifwan.barani.core.mock

import android.content.Context
import com.app.ichsanulalifwan.barani.core.mock.JsonAssetLoader.loadJSONFromAsset
import com.app.ichsanulalifwan.barani.core.utils.Constant.EVERYTHING_URL
import com.app.ichsanulalifwan.barani.core.utils.Constant.SOURCES_URL
import com.app.ichsanulalifwan.barani.core.utils.Constant.TOP_HEADLINES_URL
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

fun Request.getMockedResponse(context: Context): Response {

    val url = this.url.toString()
    val mockedResponse = when {
        url.contains(TOP_HEADLINES_URL) || url.contains(EVERYTHING_URL) -> {
            val json = loadJSONFromAsset(context, "NewsResponse.json")
            MockedResponse.NewsListResponse(json)
        }

        url.contains(SOURCES_URL) -> {
            val json = loadJSONFromAsset(context, "PublisherResponse.json")
            MockedResponse.NewsSourceResponse(json)
        }

        else -> throw IllegalArgumentException("There are no mocked responses for this URL : $url")
    }

    return Response.Builder()
        .request(this)
        .code(200)
        .body(mockedResponse.body.toResponseBody("application/json".toMediaType()))
        .message(url)
        .protocol(Protocol.HTTP_1_1)
        .build()
}