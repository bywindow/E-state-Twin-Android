import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import com.idiot.e_state_twin_android.Libraries

plugins {
  id("com.android.library")
  id("kotlin-android")
  id("kotlin-parcelize")
//  id("com.google.devtools.ksp")
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

    buildConfigField(
      "String",
      "KAKAO_NATIVE_KEY",
      gradleLocalProperties(rootDir).getProperty("kakao.native.key")
    )
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  buildFeatures {
    dataBinding = true
    viewBinding = true
    buildConfig = true
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
  implementation(project(":model"))
  implementation(project(":data:api"))
  implementation(project(":data:repository"))
  implementation(project(":utils"))
  implementation(project(":common-ui"))

  implementation(Libraries.androidx_core)
  implementation(Libraries.androidx_appcompat)
  implementation(Libraries.material)
  implementation(Libraries.hilt_android)
  kapt(Libraries.hilt_compiler)
  implementation(Libraries.androidx_constraintLayout)
  implementation(Libraries.androidx_work)
  implementation(Libraries.navigation_fragment)
  implementation(Libraries.navigation_ui)
  implementation(Libraries.google_service_auth)
  implementation(Libraries.lifecycle_livedata)
  implementation(Libraries.lifecycle_viewmodel)
  implementation(Libraries.retrofit_gson)
  implementation(Libraries.retrofit)
  implementation(Libraries.okhttp_interceptor)
  implementation(Libraries.kakao_user)
  implementation("androidx.appcompat:appcompat:1.5.1")
  implementation("com.google.android.material:material:1.4.0")
  implementation("androidx.constraintlayout:constraintlayout:2.1.4")

  testImplementation(Libraries.junit)

  androidTestImplementation(Libraries.androidx_junit)
  androidTestImplementation(Libraries.androidx_espresso)
}