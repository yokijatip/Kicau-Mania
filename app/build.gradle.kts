plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    id("com.google.devtools.ksp")
    id("kotlin-parcelize")
}

android {
    namespace = "belajar.android.kicaumania"
    compileSdk = 34

    defaultConfig {
        applicationId = "belajar.android.kicaumania"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
        mlModelBinding = true
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
}

dependencies {

    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.fragment.ktx)
    val lottieVersion = "6.2.0"
    //noinspection UseTomlInstead
    implementation("com.airbnb.android:lottie:$lottieVersion")

    val glideVersion = "4.16.0"
    //noinspection UseTomlInstead
    implementation("com.github.bumptech.glide:glide:$glideVersion")

    val chipNavigationVersion = "1.4.0"
    //noinspection UseTomlInstead
    implementation("com.github.ismaeldivita:chip-navigation-bar:$chipNavigationVersion")

    val retrofitVersion = "2.11.0"
    val loggingInterceptorVersion = "4.9.0"
    //noinspection UseTomlInstead
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    //noinspection UseTomlInstead
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    //noinspection GradleDependency,UseTomlInstead
    implementation("com.squareup.okhttp3:logging-interceptor:$loggingInterceptorVersion")
    //noinspection UseTomlInstead
    implementation("com.squareup.okio:okio:3.2.0")

    val recyclerViewVersion = "1.3.2"
    //noinspection UseTomlInstead
    implementation("androidx.recyclerview:recyclerview:$recyclerViewVersion")

    val lifecycleVersion = "2.7.0"
    //noinspection UseTomlInstead
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    //noinspection UseTomlInstead
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")

    val roomVersion = "2.6.1"
    //noinspection UseTomlInstead
    implementation("androidx.room:room-runtime:$roomVersion")
    //noinspection UseTomlInstead
    implementation("androidx.room:room-ktx:$roomVersion")
    //noinspection UseTomlInstead
    ksp("androidx.room:room-compiler:$roomVersion")

    val coroutinesVersion = "1.8.0"
    //noinspection UseTomlInstead
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    //noinspection UseTomlInstead
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    val koinVersion = "3.5.6"
    //noinspection UseTomlInstead
    implementation("io.insert-koin:koin-core:$koinVersion")
    //noinspection UseTomlInstead
    implementation("io.insert-koin:koin-android:$koinVersion")
    //noinspection UseTomlInstead
    implementation("io.insert-koin:koin-core")

    val lifecycle_version = "2.7.0"
    val arch_version = "2.2.0"
    // ViewModel utilities for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
    // Lifecycles only (without ViewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")
    // Lifecycle utilities for Compose
    implementation("androidx.lifecycle:lifecycle-runtime-compose:$lifecycle_version")

    // Saved state module for ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")

    // alternately - if using Java8, use the following instead of lifecycle-compiler
    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycle_version")

    // optional - helpers for implementing LifecycleOwner in a Service
    implementation("androidx.lifecycle:lifecycle-service:$lifecycle_version")

    // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
    implementation("androidx.lifecycle:lifecycle-process:$lifecycle_version")

    // optional - ReactiveStreams support for LiveData
    implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:$lifecycle_version")

    // optional - Test helpers for LiveData
    testImplementation("androidx.arch.core:core-testing:$arch_version")

    // optional - Test helpers for Lifecycle runtime
    testImplementation("androidx.lifecycle:lifecycle-runtime-testing:$lifecycle_version")

    // Shimmer Effect buat loading content
    implementation("com.facebook.shimmer:shimmer:0.5.0")

    // Circle Image dari Hodenhof
    implementation("de.hdodenhof:circleimageview:3.1.0")

    // Motion Layout
    implementation("androidx.constraintlayout:constraintlayout:2.2.0-alpha13")

    // Camera X
    val cameraXversion = "1.2.2"
    implementation("androidx.camera:camera-core:$cameraXversion")
    implementation("androidx.camera:camera-camera2:$cameraXversion")
    implementation("androidx.camera:camera-lifecycle:$cameraXversion")
    implementation("androidx.camera:camera-video:$cameraXversion")
    implementation("androidx.camera:camera-view:$cameraXversion")
    implementation("androidx.camera:camera-extensions:$cameraXversion")

    // Tensor Flow Lite
    implementation("org.tensorflow:tensorflow-lite-metadata:0.1.0")
    implementation("org.tensorflow:tensorflow-lite-support:0.1.0")
    implementation ("org.tensorflow:tensorflow-lite:2.8.0")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}