import com.idiot.e_state_twin_android.Libraries

plugins {
  id("com.android.library")
  id("kotlin-android")
  id("kotlin-parcelize")
//  id("com.google.devtools.ksp")
  id("kotlin-kapt")
  id("androidx.navigation.safeargs.kotlin")
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
  implementation(project(":common"))
  implementation(project(":data:repository"))
  implementation(project(":feature:threeviewer"))
  implementation(project(":utils"))

  implementation(Libraries.androidx_core)
  implementation(Libraries.androidx_appcompat)
  implementation(Libraries.material)
  implementation(Libraries.glide)
  implementation(Libraries.navigation_fragment)
  implementation(Libraries.navigation_ui)
  implementation(Libraries.circleiamgeview)
  implementation(Libraries.recyclerview)

  kapt(Libraries.glide_compiler)

  testImplementation(Libraries.junit)

  androidTestImplementation(Libraries.androidx_junit)
  androidTestImplementation(Libraries.androidx_espresso)
}