package com.solo4.feature_i18n

import com.solo4.feature_i18n.data.repository.LocalizationRepository
import kotlin.reflect.KProperty
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@JvmInline
internal value class Strings(private val resId: () -> Int) : KoinComponent {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        val repo by inject<LocalizationRepository>()
        return repo.getString(resId.invoke())
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {

    }
}

fun str(id: Int): String {
    val str by Strings { id }
    return str
}

/**
 * %1$s
 */
fun str(id: Int, vararg formatArgs: String): String {
    var str by Strings { id }
    formatArgs.forEachIndexed { index, item ->
        str = str.replace("%${index + 1}\$s", item, true)
    }
    return str
}
