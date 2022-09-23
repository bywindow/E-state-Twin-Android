import com.idiot.e_state_twin_android.Libraries
import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
  id("com.android.library")
  id("kotlin-android")
  id("kotlin-parcelize")
//  id("com.google.devtools.ksp")
  id("kotlin-kapt")
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

//  kotlinOptions {
//    jvmTarget = "11"
//  }
}

dependencies {
  api(project(":data:api"))

  implementation(Libraries.androidx_core)
  implementation(Libraries.androidx_appcompat)
  implementation(Libraries.material)
  implementation(Libraries.okhttp_interceptor)
  api(Libraries.retrofit_gson)
  api(Libraries.retrofit)
  implementation(Libraries.kakao_user)

  testImplementation(Libraries.junit)

  androidTestImplementation(Libraries.androidx_junit)
  androidTestImplementation(Libraries.androidx_espresso)
}