package com.solo4.feature_i18n.data.repository.impl

import com.solo4.feature_i18n.data.datasource.LocalizationDataSource
import com.solo4.feature_i18n.data.repository.LocalizationRepository

class LocalizationRepositoryImpl(private val localizationDataSource: LocalizationDataSource) : LocalizationRepository {
    override fun getCurrentLanguage(): String {
        return localizationDataSource.getCurrentLanguage()
    }

    override fun saveCurrentLanguage(language: String) {
        localizationDataSource.saveCurrentLanguage(language)
    }

    override fun getString(id: Int): String {
        return localizationDataSource.getString(id)
    }
}
