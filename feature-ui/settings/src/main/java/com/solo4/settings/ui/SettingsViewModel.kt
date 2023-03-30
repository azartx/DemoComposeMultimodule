package com.solo4.settings.ui

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.solo4.feature_i18n.StringsSettings

class SettingsViewModel(private val languageSettings: StringsSettings) : ViewModel() {
    fun setNewLanguage(language: String, activity: Activity) {
        languageSettings.setNewLocale(language, activity)
    }
}
