plugins {
    id("gradle-prepare-android")
}

android {
    namespace = "com.solo4.coreui"

    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.core.ktx)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    api(project("::feature:feature-i18n"))

    api(libs.compose.foundation)
    api(libs.compose.foundation.layout)
    api(libs.compose.material3)
    debugApi(libs.compose.ui.tooling)
    api(libs.compose.ui.tooling.preview)
    api(libs.compose.ui.util)
    api(libs.compose.ui)
    api(libs.compose.runtime)
}