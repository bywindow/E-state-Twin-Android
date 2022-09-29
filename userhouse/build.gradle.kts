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

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
      )
    }
  }

  buildFeatures {
    dataBinding = true
    viewBinding = true
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
}
dependencies {

  implementation(project(":data:repository"))
  implementation(project(":utils"))

  implementation(com.idiot.e_state_twin_android.Libraries.androidx_core)
  implementation(com.idiot.e_state_twin_android.Libraries.androidx_appcompat)
  implementation(com.idiot.e_state_twin_android.Libraries.material)
  implementation(com.idiot.e_state_twin_android.Libraries.navigation_fragment)
  implementation(com.idiot.e_state_twin_android.Libraries.navigation_ui)
  implementation(com.idiot.e_state_twin_android.Libraries.recyclerview)

  testImplementation(com.idiot.e_state_twin_android.Libraries.junit)

  androidTestImplementation(com.idiot.e_state_twin_android.Libraries.androidx_junit)
  androidTestImplementation(com.idiot.e_state_twin_android.Libraries.androidx_espresso)

}