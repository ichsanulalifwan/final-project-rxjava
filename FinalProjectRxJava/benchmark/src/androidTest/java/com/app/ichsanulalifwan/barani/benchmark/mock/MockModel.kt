package com.app.ichsanulalifwan.barani.benchmark.mock

import com.app.ichsanulalifwan.barani.core.data.source.local.entity.NewsEntity

fun getMockNewsEntity(id: Int = 0) = NewsEntity(
    title = "$id",
    author = "Matt Burgess, Dhruv Mehrotra",
    date = "2024-01-09T22:05:13Z",
    image = "https://media.wired.com/photos/65bd1c471d8a9e5e83f03f22/191:100/w_1280,c_limit/China%E2%80%99s-Hackers-Keep-Targeting-US-Water-and-Electricity-Supplies-Security-GettyImages-1784871790.jpg",
    desc = "Plus: Russia was likely behind widespread GPS outages, Vault 7 leaker was sentenced, police claim to trace Monero cryptocurrency, and more.",
    url = "https://www.wired.com/story/china-hackers-us-water-electricity-moreno-vault-7/",
    content = "An indictment from the US Department of Justice may have solved the mystery of how disgraced cryptocurrency exchange FTX lost over \$400 million in crypto. The indictment, filed last week, alleges tha… [+3401 chars]",
    sourceId = "wired",
    sourceName = "wired",
)