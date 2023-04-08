package com.solo4.corefeature.geolocation.location

import android.location.Location
import kotlinx.coroutines.flow.Flow

interface LocationManager {
    suspend fun getCurrentCoordinates(): Location
    fun startLocationUpdates(): Flow<Location>
    fun stopLocationUpdates()
}
