package com.solo4.feature_i18n.data.datasource.impl

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.solo4.feature_i18n.Constants.CURRENT_LOCALE
import com.solo4.feature_i18n.Constants.LOCALIZATION_PREFERENCES_NAME
import com.solo4.feature_i18n.StringsSettings.Companion.DEFAULT_LANGUAGE
import com.solo4.feature_i18n.data.datasource.LocalizationDataSource
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.qualifier.StringQualifier

class LocalizationDataSourceImpl(context: Context) : LocalizationDataSource, KoinComponent {

    private val sharedPreferences by lazy {
        context.getSharedPreferences(LOCALIZATION_PREFERENCES_NAME, MODE_PRIVATE)
    }

    //private val currentLocalizationMap = hashMapOf<Int, String>()

    override fun saveCurrentLanguage(language: String) {
        sharedPreferences.edit().putString(CURRENT_LOCALE, language).apply()
    }

    override fun getCurrentLanguage(): String {
        return sharedPreferences.getString(CURRENT_LOCALE, DEFAULT_LANGUAGE) ?: DEFAULT_LANGUAGE
    }

    override fun getLocalizationMap(language: String): HashMap<Int, String> {
        return get(StringQualifier(language))
    }

    override fun getString(key: Int): String {
        return getLocalizationMap(getCurrentLanguage()).getOrDefault(key, "")
    }
}
