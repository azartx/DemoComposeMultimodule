package com.solo4.corefeature.geolocation.location.impl

import android.Manifest
import android.annotation.SuppressLint
import android.app.Application
import android.content.pm.PackageManager
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.solo4.corefeature.geolocation.location.LocationManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class PlayServicesLocationManager(
    private val application: Application,
    locationRequestInterval: Long = LOCATION_REQUEST_INTERVAL_MILLIS
) : LocationManager {

    private lateinit var locationProviderClient: FusedLocationProviderClient
    private var locationListener: (Location) -> Unit = {}

    private val settings = LocationRequest.Builder(
        Priority.PRIORITY_HIGH_ACCURACY,
        locationRequestInterval
    ).build()

    private val hasLocationPermission: Boolean
        get() = application.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED &&
                application.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED

    override suspend fun getCurrentCoordinates(): Location {
        // todo create own permission handling module which can handle permission logic
        if (!hasLocationPermission) throw SecurityException("Location permission denied.")
        return Location("")
    }

    @SuppressLint("MissingPermission")
    override fun startLocationUpdates(): Flow<Location> = callbackFlow {
        if (!hasLocationPermission) throw SecurityException("Location permission denied.")
        if (!::locationProviderClient.isInitialized) {
            locationProviderClient = LocationServices
                .getFusedLocationProviderClient(application.applicationContext)
        }
        locationListener = { trySend(it) }
        locationProviderClient.requestLocationUpdates(settings, locationListener, application.mainLooper)
    }

    override fun stopLocationUpdates() {
        if (::locationProviderClient.isInitialized)
            locationProviderClient.removeLocationUpdates(locationListener)
    }

    private companion object {
        const val LOCATION_REQUEST_INTERVAL_MILLIS = 10000L
    }
}
