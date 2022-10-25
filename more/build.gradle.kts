import com.idiot.e_state_twin_android.Libraries
import com.idiot.e_state_twin_android.Configuration
import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
  id("com.android.library")
  id("kotlin-android")
  id("kotlin-parcelize")
//  id("com.google.devtools.ksp")
  id("kotlin-kapt")
  id("androidx.navigation.safeargs.kotlin")
  id("dagger.hilt.android.plugin")
}
android {
  compileSdk = Configuration.compileSdk

  defaultConfig {
    minSdk = Configuration.minSdk
    targetSdk = Configuration.targetSdk

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")

    resValue(
      "string",
      "GOOGLE_API_KEY",
      gradleLocalProperties(rootDir).getProperty("google.api.key")
    )

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

  implementation(project(":utils"))
  implementation(project(":data:repository"))

  implementation(Libraries.androidx_core)
  implementation(Libraries.androidx_appcompat)
  implementation(Libraries.androidx_constraintLayout)
  implementation(Libraries.material)
  implementation(Libraries.navigation_fragment)
  implementation(Libraries.navigation_ui)
  implementation(Libraries.recyclerview)
  implementation(Libraries.sceneview)

  implementation(Libraries.hilt_android)
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    kapt(Libraries.hilt_compiler)

  testImplementation(Libraries.junit)

  androidTestImplementation(Libraries.androidx_junit)
  androidTestImplementation(Libraries.androidx_espresso)

}