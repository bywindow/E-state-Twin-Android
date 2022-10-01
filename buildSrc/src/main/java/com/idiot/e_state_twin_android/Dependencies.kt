package com.idiot.e_state_twin_android

object Versions {
  const val kotlin = "1.7.10"
  const val agp = "7.2.1"
  const val ksp = "1.7.10-1.0.6"
  const val hilt = "2.38.1"
  const val javaRelease = "8"
  const val jvmTarget = "1.8"
  const val material = "1.8.0-alpha01"
  const val filament = "1.20.1"
  const val arcore = "1.32.0"
  const val sceneform = "1.17.1"
  const val appcompat = "1.5.0"
  const val androidxCore = "1.8.0"
  const val androidxFragment = "1.5.0"
  const val constraintLayout = "2.1.4"
  const val androidxNavigation = "2.5.0"
  const val androidxLifecycle = "2.5.0"
  const val androidxWork = "2.7.1"
  const val androidxRoom = "2.4.3"
  const val viewpager2 = "1.0.0"
  const val splashScreen = "1.0.0-beta02"
  const val gms = "20.3.0"
  const val recyclerview = "1.2.0-alpha06"
  const val circleImageView = "3.1.0"
  const val timber = "5.0.1"
  const val kakao = "2.11.1"
  const val glide = "4.9.0"
  const val okHttp = "4.9.3"
  const val retrofit = "2.9.0"
  const val moshi = "1.13.0"
  const val coroutines = "1.6.4"
  const val androidxTest = "1.3.0"
  const val junit = "4.13.2"
  const val androidxTestJunit = "1.1.3"
  const val espresso = "3.4.0"
}

object Libraries {
  const val agp = "com.android.tools.build:gradle:${Versions.agp}"
  const val ksp = "com.google.devtools.ksp:symbol-processing-api:${Versions.ksp}"
  const val kotlin_gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
  const val navigation_safeargsPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.androidxNavigation}"
  const val sceneform_plugin = "com.google.ar.sceneform:plugin:${Versions.sceneform}"
  const val hilt_plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
  const val material = "com.google.android.material:material:${Versions.material}"
  const val gson = "com.google.code.gson"
  const val filament_android = "com.google.android.filament:filament-android:${Versions.filament}"
  const val filament_utils = "com.google.android.filament:filament-utils-android:${Versions.filament}"
  const val arcore = "com.google.ar:core:${Versions.arcore}"
  const val sceneformUX = "com.google.ar.sceneform.ux:sceneform-ux:${Versions.sceneform}"
  const val sceneformAnim = "com.google.ar.sceneform:animation:${Versions.sceneform}"
  const val gltfio_android = "com.google.android.filament:gltfio-android:${Versions.filament}"
  const val google_service_auth = "com.google.android.gms:play-services-auth:${Versions.gms}"
  const val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt}"
  const val hilt_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
  const val androidx_core = "androidx.core:core-ktx:${Versions.androidxCore}"
  const val androidx_splash = "androidx.core:core-splashscreen:${Versions.splashScreen}"
  const val androidx_appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
  const val androidx_constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
  const val androidx_fragment = "androidx.fragment:fragment-ktx:${Versions.androidxFragment}"
  const val androidx_viewpager = "androidx.viewpager2:viewpager2:${Versions.viewpager2}"
  const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
  const val androidx_work = "androidx.work:work-runtime-ktx:${Versions.androidxWork}"
  const val lifecycle_viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidxLifecycle}"
  const val lifecycle_livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidxLifecycle}"
  const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.androidxNavigation}"
  const val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.androidxNavigation}"
  const val androidx_room_runtime = "androidx.room:room-runtime:${Versions.androidxRoom}"
  const val androidx_room_ktx = "androidx.room:room-ktx:${Versions.androidxRoom}"
  const val androidx_room_compiler = "androidx.room:room-compiler:${Versions.androidxRoom}"
  const val androidx_test_core = "androidx.test:core:${Versions.androidxTest}"
  const val androidx_junit = "androidx.test.ext:junit:${Versions.androidxTestJunit}"
  const val androidx_espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
  const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
  const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
  const val retrofit_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
  const val retrofit_moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
  const val okhttp_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
  const val okhttp_mockserver = "com.squareup.okhttp3:mockwebserver${Versions.okHttp}"
  const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
  const val moshi_codegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
  const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
  const val coroutines_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
  const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
  const val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
  const val circleiamgeview = "de.hdodenhof:circleimageview:${Versions.circleImageView}"
  const val kakao_user = "com.kakao.sdk:v2-all:${Versions.kakao}"
  const val junit = "junit:junit:${Versions.junit}"
}