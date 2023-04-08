package com.solo4.feature_i18n

import android.app.Activity
import com.solo4.feature_i18n.data.repository.LocalizationRepository

class StringsSettings(private val localizationRepository: LocalizationRepository) {

    fun setNewLocale(locale: String, composer: Activity) {
        //getKoin().getScope("Strings").close()
        localizationRepository.saveCurrentLanguage(locale)
        composer.recreate()
    }

    internal companion object {
        const val DEFAULT_LANGUAGE = "en"
    }
}
