import com.idiot.e_state_twin_android.Libraries

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
  api(project(":model"))
  implementation(project(":data:api-builder"))

  implementation(Libraries.androidx_core)
  implementation(Libraries.androidx_appcompat)
  implementation(Libraries.material)
  implementation(Libraries.kakao_user)

  implementation(Libraries.okhttp_interceptor)
  implementation(Libraries.retrofit_gson)
  implementation(Libraries.retrofit)
  implementation(Libraries.retrofit_moshi)

  implementation(Libraries.hilt_android)
  kapt(Libraries.hilt_compiler)

  testImplementation(Libraries.junit)

  androidTestImplementation(Libraries.androidx_junit)
  androidTestImplementation(Libraries.androidx_espresso)
}