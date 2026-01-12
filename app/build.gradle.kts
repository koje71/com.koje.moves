plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.koje.moves"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.koje.moves"
        minSdk = 24
        targetSdk = 36
        versionCode = 10
        versionName = "1.3.3"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = false
        buildConfig = true
    }
}

dependencies {
    val appcompatVersion = "1.7.1"

    implementation("androidx.appcompat:appcompat:$appcompatVersion")
    implementation(libs.androidx.core.ktx)
}