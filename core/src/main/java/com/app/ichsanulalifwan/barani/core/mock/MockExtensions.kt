package com.app.ichsanulalifwan.barani.core.mock

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

fun Request.getMockedResponse(): Response {

    val url = this.url.toString()
    val mockedResponse = when {
        url.contains("top-headlines") || url.contains("everything") -> MockedResponse.NewsListResponse
        url.contains("sources") -> MockedResponse.NewsSourceResponse
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