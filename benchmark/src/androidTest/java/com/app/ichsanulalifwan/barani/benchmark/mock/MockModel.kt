package com.app.ichsanulalifwan.barani.benchmark.mock

import com.app.ichsanulalifwan.barani.core.data.source.local.entity.NewsEntity

fun getMockEntity(id: Int = 0) = NewsEntity(
    title = "$id",
    author = "mock",
    date = "mock",
    image = "mock",
    desc = "mock",
    url = "mock",
    content = "mock",
    sourceId = "mock",
    sourceName = "mock",
)