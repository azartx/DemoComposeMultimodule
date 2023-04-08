package com.solo4.feature_i18n.data.datasource

interface LocalizationDataSource {
    fun saveCurrentLanguage(language: String)
    fun getCurrentLanguage(): String
    fun getLocalizationMap(language: String): HashMap<Int, String>
    fun getString(key: Int): String
}
