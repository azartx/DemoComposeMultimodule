plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.solo4.feature_i18n"
    compileSdk = 33
}

dependencies {
    testImplementation("junit:junit:4.13.2")

    implementation(libs.koin.compose)
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.10")
}