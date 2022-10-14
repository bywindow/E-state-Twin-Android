import com.idiot.e_state_twin_android.Libraries
import com.idiot.e_state_twin_android.Configuration

plugins {
  id("com.android.application")
  id("kotlin-android")
  id("kotlin-parcelize")
  id("androidx.navigation.safeargs.kotlin")
//  id("com.google.devtools.ksp")
  id("kotlin-kapt")
  id("dagger.hilt.android.plugin")
}

android {
  compileSdk = Configuration.compileSdk
  defaultConfig {
    applicationId = "com.idiot.e_state_twin_android"
    minSdk = Configuration.minSdk
    targetSdk = Configuration.targetSdk
    versionCode = Configuration.versionCode
    versionName = Configuration.versionName

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

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
    getByName("debug") {
      sourceSets {
        getByName("main") {
          java.srcDir(File("build/generated/ksp/debug/kotlin"))
        }
      }
    }

    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")

      sourceSets {
        getByName("main") {
          java.srcDir(File("build/generated/ksp/release/kotlin"))
        }
      }
    }
  }

  kotlinOptions {
    jvmTarget = "1.8"
  }
}

dependencies {
  implementation(Libraries.hilt_android)
  kapt(Libraries.hilt_compiler)

  implementation(Libraries.timber)
  implementation(project(":utils"))
  // FEATURE
  implementation(project(":login"))

  testImplementation(Libraries.junit)

  androidTestImplementation(Libraries.androidx_junit)
  androidTestImplementation(Libraries.androidx_espresso)
}