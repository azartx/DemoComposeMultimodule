package com.solo4.demo.di

import com.solo4.feature_i18n.di.localizationModule
import com.solo4.home.di.homeFeatureModule
import com.solo4.pictures.di.picturesFeatureModule
import org.koin.dsl.module

val appModule = module {
    includes(homeFeatureModule)
    includes(picturesFeatureModule)
    includes(localizationModule)
}
