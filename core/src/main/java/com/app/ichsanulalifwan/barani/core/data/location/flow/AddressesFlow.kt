package com.app.ichsanulalifwan.barani.core.data.location.flow

import android.location.Address
import android.location.Location
import com.app.ichsanulalifwan.barani.core.data.repository.location.AddressRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch

@ExperimentalCoroutinesApi
internal fun getAddresses(
    addressRepository: AddressRepository,
    location: Location,
    maxResults: Int,
): Flow<List<Address>> = callbackFlow {
    try {
        addressRepository.getAddresses(
            location.longitude,
            location.latitude,
            maxResults,
        ) { addresses, throwable ->
            if (addresses != null) {
                trySend(addresses)
            } else {
                val exception = checkNotNull(throwable) {
                    "If the result is null, the exception cannot be."
                }
                close(exception)
            }
        }
    } catch (t: Throwable) {
        close(t)
    }

    awaitClose { }
}.catch { throwable ->
    throw throwable
}