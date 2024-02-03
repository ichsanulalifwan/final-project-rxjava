package com.app.ichsanulalifwan.barani.benchmark.mock

import com.app.ichsanulalifwan.barani.core.data.source.local.entity.NewsEntity

fun getMockEntity(id: Int = 0) = NewsEntity(
    "$id",
    "mock",
    "mock",
    "mock",
    "mock",
    "mock",
    "mock",
    "mock",
    "mock"
)