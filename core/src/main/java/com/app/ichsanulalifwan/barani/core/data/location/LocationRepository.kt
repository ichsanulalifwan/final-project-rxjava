package com.app.ichsanulalifwan.barani.core.data.location

import android.content.Context
import android.location.Address
import android.location.Geocoder
import java.util.*

class LocationRepository(context: Context, val isMock: Boolean) {

    private val geoCoder = Geocoder(context)

    fun getAddresses(
        longitude: Double,
        latitude: Double, 
        maxResults: Int,
        block: (List<Address>?, Throwable?) -> Unit
    ) {
        try {
            val mockAddress = Address(Locale.US).apply { countryCode = "US" }
            block(if (isMock) listOf(mockAddress) else geoCoder.getFromLocation(latitude, longitude, maxResults), null)
        } catch (t: Throwable) {
            block(null, t)
        }
    }
}