package com.solo4.feature_i18n.di

import android.content.Context
import com.solo4.feature_i18n.Constants.LOCALE_EN
import com.solo4.feature_i18n.Constants.LOCALE_RU
import com.solo4.feature_i18n.StringsSettings
import com.solo4.feature_i18n.data.datasource.LocalizationDataSource
import com.solo4.feature_i18n.data.datasource.impl.LocalizationDataSourceImpl
import com.solo4.feature_i18n.data.repository.LocalizationRepository
import com.solo4.feature_i18n.data.repository.impl.LocalizationRepositoryImpl
import org.json.JSONObject
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.bind
import org.koin.dsl.module

val localizationModule = module {
    // todo need optimization
    //scope(StringQualifier(LOCALIZATION_KOIN_SCOPE)) {
        single(StringQualifier(LOCALE_RU)) { provideLocalization(LOCALE_RU, androidContext()) }
        single(StringQualifier(LOCALE_EN)) { provideLocalization(LOCALE_EN, androidContext()) }
    //}
    single { LocalizationDataSourceImpl(androidContext()) } bind LocalizationDataSource::class
    single { LocalizationRepositoryImpl(get()) } bind LocalizationRepository::class
    single(createdAtStart = true) { StringsSettings(get()) }
}

private fun provideLocalization(locale: String, context: Context): HashMap<Int, String> {
    val someJson = context.assets.open(locale.plus(".json")).use { String(it.readBytes()) }
    val map = hashMapOf<Int, String>()
    val jsonObject = JSONObject(someJson)
    val keys = jsonObject.keys()
    while (keys.hasNext()) {
        val key = keys.next()
        val value = jsonObject.getString(key)
        map[key.toInt()] = value
    }
    return map
}
