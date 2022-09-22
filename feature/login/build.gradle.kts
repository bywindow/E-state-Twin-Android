import java.io.File
import java.io.FileInputStream
import java.util.*

plugins {
  id("com.android.library")
  id("kotlin-android")
  id("kotlin-parcelize")
  id("kotlin-kapt")
}

val properties = Properties().apply {
  load(FileInputStream(File(rootProject.rootDir, "local.properties")))
}

android {
  compileSdk = Configuration.compileSdk
  defaultConfig {
    minSdk = Configuration.minSdk
    targetSdk = Configuration.targetSdk

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
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
  implementation(project(":model"))
  implementation(project(":data:api"))
  implementation(project(":data:repository"))
  implementation(project(":utils"))
  implementation(project(":common-ui"))

  implementation(Libraries.androidx_core)
  implementation(Libraries.androidx_appcompat)
  implementation(Libraries.material)
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

  testImplementation(Libraries.junit)

  androidTestImplementation(Libraries.androidx_junit)
  androidTestImplementation(Libraries.androidx_espresso)
}