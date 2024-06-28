plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.dagger.hilt)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.pruebatecnica"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.pruebatecnica"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    //Navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Dagger_Hilt
    implementation(libs.dagger.hilt)
    kapt(libs.dagger.hilt.compiler)
    //Retrofit
    implementation (libs.retrofit)
    implementation (libs.retrofit.adapter)
    implementation (libs.retrofit.compiler)
    //Glide
    implementation (libs.glide)
    //Lifecycle
    implementation (libs.lifecycle.viewmodel)
    implementation (libs.lifecycle.livedata)
}

kapt {
    correctErrorTypes = true
}