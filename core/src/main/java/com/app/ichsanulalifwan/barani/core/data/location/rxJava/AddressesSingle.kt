package com.app.ichsanulalifwan.barani.core.data.location.rxJava

import android.location.Address
import android.location.Location
import com.app.ichsanulalifwan.barani.core.data.repository.location.AddressRepository
import io.reactivex.Single
import io.reactivex.SingleEmitter

internal fun getAddresses(
    addressRepository: AddressRepository,
    location: Location,
    maxResults: Int,
): Single<List<Address>> = Single.create { emitter: SingleEmitter<List<Address>> ->
    addressRepository.getAddresses(
        longitude = location.longitude,
        latitude = location.latitude,
        maxResults = maxResults,
    ) { addresses, throwable ->
        if (!emitter.isDisposed) {
            if (addresses != null) {
                emitter.onSuccess(addresses)
            } else {
                val exception = checkNotNull(throwable) {
                    "If the result is null, the exception cannot be."
                }
                emitter.onError(exception)
            }
        }
    }
}