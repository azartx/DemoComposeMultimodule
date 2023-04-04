plugins {
    id("gradle-prepare-android")
}

android {
    namespace = "com.solo4.network"
}

dependencies {
    testImplementation("junit:junit:4.13.2")

    implementation(project("::core-model"))

    implementation(libs.retrofit)
    implementation(libs.retrofit.converterGson)
    implementation(libs.gson)
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")

    implementation(libs.koin.compose)
}