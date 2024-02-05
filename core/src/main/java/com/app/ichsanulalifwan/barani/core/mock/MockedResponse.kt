package com.app.ichsanulalifwan.barani.core.mock

sealed class MockedResponse(val body: String) {

    class NewsListResponse(body: String) : MockedResponse(body)

    class NewsSourceResponse(body: String) : MockedResponse(body)
}