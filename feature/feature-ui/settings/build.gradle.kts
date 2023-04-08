plugins {
    id("gradle-prepare-android")
}

android {
    namespace = "com.solo4.settings"

    buildFeatures {
        compose = true
    }
}

dependencies {
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation(libs.core.ktx)
    implementation(project("::core:core-ui"))
    implementation(project("::feature:feature-i18n"))

    implementation(libs.koin.compose)
    implementation(libs.koin.compose.navigation)

    implementation(libs.navigation.compose)
}