package com.app.ichsanulalifwan.barani.core.mock

import android.content.Context

object JsonAssetLoader {

    fun loadJSONFromAsset(context: Context, fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }
}