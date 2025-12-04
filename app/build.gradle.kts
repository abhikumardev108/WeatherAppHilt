plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")

}

android {
    namespace = "com.example.weatherapphilt"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.weatherapphilt"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)


    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    // If you need SavedStateHandle
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)
    // If you're using LiveData with ViewModel
    implementation(libs.androidx.lifecycle.livedata.ktx)
    // If you need ViewModel for Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose)


    // hilt + kapt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // this is needed when we want to inject dependency into composable.
    implementation(libs.androidx.hilt.navigation.compose)






}