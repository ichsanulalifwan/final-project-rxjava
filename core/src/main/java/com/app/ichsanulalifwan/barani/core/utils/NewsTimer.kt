package com.app.ichsanulalifwan.barani.core.utils

import android.util.Log

interface NewsTimer {

    var topHeadlineRunNumber: Int
    var startTopHeadline: Long

    var topHeadlineLocalRunNumber: Int
    var startTopHeadlineLocal: Long

    var sourcesRunNumber: Int
    var startSources: Long

    fun startTopHeadlinesNewsTimer() {
        topHeadlineRunNumber++
        startTopHeadline = System.currentTimeMillis()
    }

    fun stopTopHeadlinesNewsTimer() {
        log("Top Headlines News Run #$topHeadlineRunNumber took ${System.currentTimeMillis() - startTopHeadline} ms.")
    }

    fun startTopHeadlineNewsLocalTimer() {
        topHeadlineLocalRunNumber++
        startTopHeadlineLocal = System.currentTimeMillis()
    }

    fun stopTopHeadlineNewsLocalTimer() {
        log("Top Headlines News Local Run #$topHeadlineLocalRunNumber took ${System.currentTimeMillis() - startTopHeadlineLocal} ms.")
    }

    fun startSourcesNewsTimer() {
        sourcesRunNumber++
        startSources = System.currentTimeMillis()
    }

    fun stopSourcesNewsTimer() {
        log("Publisher Run #$sourcesRunNumber took ${System.currentTimeMillis() - startSources} ms.")
    }

    companion object {
        private const val LOG_TAG = "NewsTimer"
        private fun log(message: String) = Log.i(LOG_TAG, message)
    }
}