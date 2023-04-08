@file:Suppress("UnstableApiUsage")

import com.solo4.gradleprepare.extensions.enableCompose

plugins {
    id("gradle-prepare-android")
}

android {
    namespace = "com.solo4.demo"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    enableCompose()

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            excludes.add("META-INF/*")
            pickFirsts += "**/*.pickFirst"
        }
    }
}

dependencies {
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    implementation(project("::core:core-ui"))

    implementation(project("::feature:feature-ui:home"))
    implementation(project("::feature:feature-ui:pictures"))
    implementation(project("::feature:feature-ui:settings"))

    implementation(project("::feature:feature-i18n"))

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)

    implementation("androidx.activity:activity-compose:1.7.0")

    implementation(libs.koin.compose)
    implementation(libs.koin.compose.navigation)

    implementation(libs.navigation.compose)
}