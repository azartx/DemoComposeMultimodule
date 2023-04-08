package com.solo4.corefeature.geolocation.di

import com.solo4.corefeature.geolocation.location.LocationManager
import com.solo4.corefeature.geolocation.location.impl.PlayServicesLocationManager
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.bind
import org.koin.dsl.module

val geolocationModule = module {
    single { PlayServicesLocationManager(androidApplication()) } bind LocationManager::class
}
