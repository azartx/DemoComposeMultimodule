plugins {
    id("gradle-prepare-android")
}

android {
    namespace = "com.solo4.core_data"
}

dependencies {
    testImplementation("junit:junit:4.13.2")

    implementation(project("::core-network"))
    implementation(project("::core-model"))
    implementation(project("::common"))
    implementation(libs.koin.compose)
}