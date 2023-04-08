package com.solo4.feature_i18n.data.repository

interface LocalizationRepository {
    fun getCurrentLanguage(): String
    fun saveCurrentLanguage(language: String)
    fun getString(id: Int): String
}
