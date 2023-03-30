@file:Suppress("UnstableApiUsage")
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.solo4.demo"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.solo4.demo"
        minSdk = 27
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        //resourceConfigurations.addAll(arrayOf("en", "ru"))
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
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

    implementation(project("::core-ui"))

    implementation(project("::feature-ui:home"))
    implementation(project("::feature-ui:pictures"))
    implementation(project("::feature-ui:settings"))

    implementation(project("::feature-i18n"))

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)

    implementation("androidx.activity:activity-compose:1.7.0")

    implementation(libs.koin.compose)
    implementation(libs.koin.compose.navigation)

    implementation(libs.navigation.compose)
}