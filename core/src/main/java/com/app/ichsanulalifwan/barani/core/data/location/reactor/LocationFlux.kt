package com.app.ichsanulalifwan.barani.core.data.location.reactor

import android.annotation.SuppressLint
import android.os.Looper
import com.app.ichsanulalifwan.barani.core.utils.throwable.LocationProviderNotAvailableException
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationAvailability
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import java.util.concurrent.Executors

@SuppressLint("MissingPermission")
internal fun getLocationUpdates(
    locationServiceClient: FusedLocationProviderClient,
    locationRequest: LocationRequest,
) = Flux.create { sink ->
    var locationCheck = false

    val callback = object : LocationCallback() {
        override fun onLocationResult(result: LocationResult) {
            sink.next(result.locations.first())
        }

        override fun onLocationAvailability(availability: LocationAvailability) {
            if (!locationCheck) {
                if (!availability.isLocationAvailable) {
                    sink.error(LocationProviderNotAvailableException())
                }
                locationCheck = true
            }
        }
    }

    locationServiceClient.requestLocationUpdates(
        locationRequest,
        callback,
        Looper.getMainLooper()
    )

    sink.onCancel {
        locationServiceClient.removeLocationUpdates(callback)
    }
}.subscribeOn(Schedulers.fromExecutor(Executors.newSingleThreadExecutor()))
