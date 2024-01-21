@Suppress("DSL_SCOPE_VIOLATION") 
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    id("com.google.gms.google-services")
    id("kotlin-kapt")
}

android {
    namespace = "as.example.life"
    compileSdk = 34

    defaultConfig {
        applicationId = "as.example.life"
        minSdk = 24
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

    //dependencies for view binding
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    aaptOptions{
        noCompress +="tflite"
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.database)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)


    //dependencies
    val navVersion = "2.7.6"
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)
    implementation("com.github.ismaeldivita:chip-navigation-bar:1.4.0")

    implementation ("org.tensorflow:tensorflow-lite:2.14.0")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    implementation ("com.android.support:multidex:1.0.3")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")

    implementation ("org.tensorflow:tensorflow-lite-support:0.4.4")
}