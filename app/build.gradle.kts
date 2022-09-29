import com.idiot.e_state_twin_android.Libraries

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
  compileSdk = com.idiot.e_state_twin_android.Configuration.compileSdk
  defaultConfig {
    applicationId = "com.idiot.e_state_twin_android"
    minSdk = com.idiot.e_state_twin_android.Configuration.minSdk
    targetSdk = com.idiot.e_state_twin_android.Configuration.targetSdk
    versionCode = com.idiot.e_state_twin_android.Configuration.versionCode
    versionName = com.idiot.e_state_twin_android.Configuration.versionName

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
  implementation(Libraries.androidx_core)
  implementation(Libraries.androidx_appcompat)
  implementation(Libraries.material)
  implementation(Libraries.hilt_android)
  kapt(Libraries.hilt_compiler)
  implementation(Libraries.androidx_work)
  implementation(Libraries.navigation_fragment)
  implementation(Libraries.navigation_ui)
  implementation(Libraries.lifecycle_livedata)
  implementation(Libraries.lifecycle_viewmodel)
  implementation(Libraries.androidx_viewpager)
  implementation(Libraries.androidx_splash)
  implementation(Libraries.timber)
  implementation(Libraries.retrofit_gson)
  implementation(Libraries.retrofit)
  implementation(Libraries.okhttp_interceptor)

  // DATA
  implementation(project(":data:api"))
  implementation(project(":data:repository"))
  implementation(project(":data:api-builder"))
  implementation(project(":data:db"))
  implementation(project(":model"))
  implementation(project(":utils"))
  // FEATURE
  implementation(project(":login"))
  implementation(project(":feature:threeviewer"))
  implementation(project(":common"))
  implementation(project(":home"))
  implementation(project(":more"))

  testImplementation(Libraries.junit)

  androidTestImplementation(Libraries.androidx_junit)
  androidTestImplementation(Libraries.androidx_espresso)
}