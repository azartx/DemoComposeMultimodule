plugins {
    id("gradle-prepare-android")
}

android {
    namespace = "com.solo4.corefeature.geolocation"
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.koin.compose)
    implementation("com.google.android.gms:play-services-location:21.0.1")
    //implementation("androidx.activity:activity-compose:1.8.0-alpha02")
}