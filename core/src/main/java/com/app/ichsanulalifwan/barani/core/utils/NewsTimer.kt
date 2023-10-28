package com.app.ichsanulalifwan.barani.core.utils

import android.util.Log

interface NewsTimer {

    var topHeadlineRunNumber: Int
    var startTopHeadline: Long

    var everythingRunNumber: Int
    var startEverything: Long

    var sourcesRunNumber: Int
    var startSources: Long

    fun startTopHeadlinesNewsTimer() {
        topHeadlineRunNumber++
        startTopHeadline = System.currentTimeMillis()
    }

    fun stopTopHeadlinesNewsTimer() {
        log("Top Headlines News Run #$topHeadlineRunNumber took ${System.currentTimeMillis() - startTopHeadline} ms.")
    }

    fun startEverythingNewsTimer() {
        everythingRunNumber++
        startEverything = System.currentTimeMillis()
    }

    fun stopEverythingNewsTimer() {
        log("Everything News Run #$everythingRunNumber took ${System.currentTimeMillis() - startEverything} ms.")
    }

    fun startSourcesNewsTimer() {
        sourcesRunNumber++
        startSources = System.currentTimeMillis()
    }

    fun stopSourcesNewsTimer() {
        log("Everything News Run #$sourcesRunNumber took ${System.currentTimeMillis() - startSources} ms.")
    }

    companion object {
        private const val LOG_TAG = "NewsTimer"
        private fun log(message: String) = Log.i(LOG_TAG, message)
    }
}