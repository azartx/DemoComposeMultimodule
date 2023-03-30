plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.solo4.core_model"
    compileSdk = 33
}

dependencies {
    testImplementation("junit:junit:4.13.2")
}