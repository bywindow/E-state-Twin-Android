import com.idiot.e_state_twin_android.Libraries
import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
  id("com.android.library")
  id("kotlin-android")
  id("kotlin-parcelize")
  id("kotlin-kapt")
  id("dagger.hilt.android.plugin")
}

android {
  compileSdk = com.idiot.e_state_twin_android.Configuration.compileSdk
  defaultConfig {
    minSdk = com.idiot.e_state_twin_android.Configuration.minSdk
    targetSdk = com.idiot.e_state_twin_android.Configuration.targetSdk

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")

    buildConfigField("String", "BASE_API", gradleLocalProperties(rootDir).getProperty("base.api"))

  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  buildFeatures {
    dataBinding = true
    viewBinding = true
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
    }
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
}

dependencies {
  api(project(":data:api"))

  implementation(Libraries.okhttp_interceptor)
  implementation(Libraries.retrofit_gson)
  implementation(Libraries.retrofit)
  implementation(Libraries.retrofit_moshi)
  implementation(Libraries.kakao_user)

  implementation(Libraries.hilt_android)
  kapt(Libraries.hilt_compiler)

  testImplementation(Libraries.junit)

  androidTestImplementation(Libraries.androidx_junit)
  androidTestImplementation(Libraries.androidx_espresso)
}