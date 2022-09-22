plugins {
  id("com.android.application")
  id("kotlin-android")
  id("kotlin-parcelize")
  id("kotlin-kapt")
  id("androidx.navigation.safeargs.kotlin")
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
  implementation(Libraries.androidx_core)
  implementation(Libraries.androidx_appcompat)
  implementation(Libraries.material)
  implementation(Libraries.androidx_work)
  implementation(Libraries.navigation_fragment)
  implementation(Libraries.navigation_ui)
  implementation(Libraries.lifecycle_livedata)
  implementation(Libraries.lifecycle_viewmodel)
  implementation(Libraries.androidx_viewpager)
  implementation(Libraries.androidx_splash)
  implementation(Libraries.retrofit_gson)
  implementation(Libraries.retrofit)
  implementation(Libraries.okhttp_interceptor)
  implementation(Libraries.kakao_user)

  // DATA
  implementation(project(":data:api"))
  implementation(project(":data:repository"))
  implementation(project(":data:api-builder"))
  implementation(project(":data:db"))
  implementation(project(":model"))
  implementation(project(":utils"))
  // FEATURE
  implementation(project(":feature:login"))
  implementation(project(":feature:threeviewer"))
  implementation(project(":common"))
  implementation(project(":common-ui"))

  annotationProcessor(Libraries.glide_compiler)

  testImplementation(Libraries.junit)

  androidTestImplementation(Libraries.androidx_junit)
  androidTestImplementation(Libraries.androidx_espresso)
}